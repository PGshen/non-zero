package space.zero.common.jsonLib.resolver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import space.zero.common.jsonLib.annotation.JsonBeanRequestParam;
import space.zero.common.jsonLib.mapper.JsonMapper;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JsonBeanArgumentResolver implements HandlerMethodArgumentResolver {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		// TODO Auto-generated method stub
		if(parameter.hasParameterAnnotation(JsonBeanRequestParam.class)){
			return true;
		}
		return false;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		// TODO Auto-generated method stub
		Class<?> entityClass = parameter.getParameterType();
		JsonBeanRequestParam jsonAnno = parameter.getParameterAnnotation(JsonBeanRequestParam.class);
		
		String[] classKeys=jsonAnno.classKeys();
		Class[] classList = jsonAnno.classList();
		Map<String,Class> classMap=new HashMap<String,Class>();
		
		for(int i=0;i<classKeys.length;i++){
			classMap.put(classKeys[i], classList[i]);
		}
		
		JsonMapper mapper=new JsonMapper();
		String paramName = parameter.getParameterName();
		logger.debug("try to transfer parameter:"+webRequest.getParameter(paramName));
		if(webRequest.getParameter(paramName)!=null){
			Object result=null;

			if(Map.class.isAssignableFrom(entityClass)){
				result = mapper.readValue(webRequest.getParameter(paramName));
			}else if(List.class.isAssignableFrom(entityClass)){
				//if is a list
				Type genType = parameter.getGenericParameterType();
		        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		        Class beanType =  (Class) params[0];
		        result = mapper.fromJson(webRequest.getParameter(paramName), mapper.createCollectionTypeFor(ArrayList.class,List.class,beanType));
			}else{
				result = mapper.readValue(webRequest.getParameter(paramName),entityClass);
			}
			
			return result;
		}else{
			return null;
		}
	}
	
}
