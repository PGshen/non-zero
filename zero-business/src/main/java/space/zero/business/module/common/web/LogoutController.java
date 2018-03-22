package space.zero.business.module.common.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by PG_shen
 * Date : 3/22/18
 * Time : 2:34 PM
 */
@RestController
public class LogoutController {
//    @GetMapping("/logout")
//    public Result logout (HttpServletRequest request, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null){
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return ResultGenerator.genSuccessResult();
//    }
}
