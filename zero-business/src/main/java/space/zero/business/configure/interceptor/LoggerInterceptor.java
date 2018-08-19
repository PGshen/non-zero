package space.zero.business.configure.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import space.zero.business.module.base.model.BaseLog;
import space.zero.business.module.base.service.BaseLogService;
import space.zero.common.utils.IpUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 * User: pipix
 * Date: 8/19/18
 * TIME: 4:55 PM
 */
public class LoggerInterceptor implements HandlerInterceptor {
    //请求开始时间标识
    private static final String LOGGER_SEND_TIME = "_send_time";
    //请求日志实体标识
    private static final String LOGGER_ENTITY = "_logger_entity";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //创建日志实体
        BaseLog logger = new BaseLog();
        String sessionId = request.getRequestedSessionId();
        String url = request.getRequestURI();
//        Request Payload传参，只能通过数据流获取，但数据流读取后会导致后面业务取不到请求参数
//        String paramData = "";
//        InputStream is = request.getInputStream();
//        StringBuilder responseStrBuilder = new StringBuilder();
//        BufferedReader streamReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
//        String inputStr;
//        while ((inputStr = streamReader.readLine()) != null)
//            responseStrBuilder.append(inputStr);
//        paramData = responseStrBuilder.toString();
        //获取请求参数信息
        Map parameterMap = request.getParameterMap();

        String paramData = JSON.toJSONString(parameterMap,
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue);
        logger.setClientIp(IpUtils.getRemoteAddr(request));
        logger.setMethod(request.getMethod());
        logger.setType(IpUtils.getRequestType(request));
        logger.setParamData(paramData);
        logger.setUri(url);
        logger.setSessionId(sessionId);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String time = sdf.format(new Date(System.currentTimeMillis()));
        logger.setTime(time);
        request.setAttribute(LOGGER_SEND_TIME, System.currentTimeMillis());
        //设置请求实体到request内，方面afterCompletion方法调用
        request.setAttribute(LOGGER_ENTITY, logger);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        int status = response.getStatus();
        long currentTime = System.currentTimeMillis();
        long time = Long.valueOf(request.getAttribute(LOGGER_SEND_TIME).toString());
        //获取本次请求日志实体
        BaseLog logger = (BaseLog) request.getAttribute(LOGGER_ENTITY);
        logger.setTimeConsuming(String.valueOf((currentTime - time) + ""));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        logger.setReturnTime(sdf.format(new Date(currentTime)) + "");
        logger.setStatusCode(status + "");
        //执行将日志写入数据库
        BaseLogService logService = getLogMapper(BaseLogService.class, request);
        logService.save(logger);
    }

    private <T> T getLogMapper(Class<T> clazz, HttpServletRequest request) {
        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        return factory.getBean(clazz);
    }
}
