package space.zero.business.module.common.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;

/**
 * Created by PG_shen
 * Date : 3/22/18
 * Time : 11:18 AM
 */
@RestController
@RequestMapping("/dashboard")
public class DashboardController {
    @GetMapping("/page")
    public Result page(){
        return ResultGenerator.genSuccessResult();
    }
}