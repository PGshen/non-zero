package space.zero.business.module.sys.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import space.zero.common.jsonLib.mapper.JsonMapper;
import space.zero.common.utils.MIMEType;
import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class SysAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType(MIMEType.APPLICATION_JSON + ";charset=utf8");
        PrintWriter out = httpServletResponse.getWriter();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("token", httpServletRequest.getSession().getId());
        String message = "认证成功，欢迎登录！";
        out.write(JsonMapper.toJsonString(ResultGenerator.genSuccessResult(map, message)));
        out.flush();
        out.close();
    }
}
