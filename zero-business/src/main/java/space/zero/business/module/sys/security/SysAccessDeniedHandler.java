package space.zero.business.module.sys.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SysAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.setCharacterEncoding("UTF-8");
        PrintWriter out = httpServletResponse.getWriter();
        String path = httpServletRequest.getRequestURI();
        Result result;
        //区分页面还是接口
        if (path.endsWith("page")) {
            result = ResultGenerator.genForbiddenPageResult("您当前没有权限访问该页面，请联系管理员！");
        }else {
            result = ResultGenerator.genForbiddenInterfaceResult("","您当前没有权限访问该数据，请联系管理员！");
        }
        out.write(result.toString());
        out.flush();
        out.close();
    }
}
