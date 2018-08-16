package space.zero.business.module.sys.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SysAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.setCharacterEncoding("UTF-8");
        PrintWriter out = httpServletResponse.getWriter();
        String message;
        if (e instanceof UsernameNotFoundException || e instanceof BadCredentialsException) {
            message = "用户名或密码输入错误，登录失败!";
        } else if (e instanceof DisabledException) {
            message = "账户被禁用，登录失败，请联系管理员!";
        } else {
            message = "登录失败!";
        }
        Result result = ResultGenerator.genFailResult(message);
        out.write(result.toString());
        out.flush();
        out.close();

    }
}
