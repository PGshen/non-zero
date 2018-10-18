package space.zero.business.module.sys.web;

import space.zero.business.module.sys.model.SysMenu;
import space.zero.business.module.sys.param.request.CondRequest;
import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;
import space.zero.business.module.sys.model.SysUserRole;
import space.zero.business.module.sys.service.SysUserRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by PG_shen on 2018/03/08.
*/
@RestController
@RequestMapping("/sys/user/role")
public class SysUserRoleController {
    @Resource
    private SysUserRoleService sysUserRoleService;

    @PostMapping
    public Result add(@RequestBody SysUserRole sysUserRole) {
        SysUserRole tmp = sysUserRoleService.save(sysUserRole);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        sysUserRoleService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody SysUserRole sysUserRole) {
        SysUserRole tmp = sysUserRoleService.update(sysUserRole);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        SysUserRole sysUserRole = sysUserRoleService.findById(id);
        return ResultGenerator.genSuccessResult(sysUserRole);
    }

//    @GetMapping
//    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
//        PageHelper.startPage(page, size);
//        List<SysUserRole> list = sysUserRoleService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultGenerator.genSuccessResult(pageInfo);
//    }

    @PostMapping("/list")
    public Result list(@RequestBody CondRequest condRequest){
        PageHelper.startPage(condRequest.getPage(), condRequest.getSize(), condRequest.getOrder());
        List<SysUserRole> list = sysUserRoleService.findBy(condRequest.getCond());
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.setOrderBy(condRequest.getOrder());
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/page")
    public Result page(){
        return ResultGenerator.genSuccessResult();
    }
}
