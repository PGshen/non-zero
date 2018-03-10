package space.zero.business.module.sys.web;

import space.zero.business.module.sys.param.request.RoleAuthListRequest;
import space.zero.business.module.sys.param.request.RoleAuthRequest;
import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;
import space.zero.business.module.sys.model.SysRole;
import space.zero.business.module.sys.service.SysRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by PG_shen on 2018/03/08.
*/
@RestController
@RequestMapping("/sys/role")
public class SysRoleController {
    @Resource
    private SysRoleService sysRoleService;

//    @PostMapping
//    public Result add(@RequestBody SysRole sysRole) {
//        SysRole tmp = sysRoleService.save(sysRole);
//        return ResultGenerator.genSuccessResult(tmp);
//    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Result add(@RequestBody SysRole role) {
        SysRole existRole = sysRoleService.findBy("name",role.getName()).get(0);
        if(null == existRole) {
            sysRoleService.save(role);
            return ResultGenerator.genSuccessResult("operation succeeded");
        } else {
            return ResultGenerator.genFailResult("role already exist");
        }
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        sysRoleService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody SysRole sysRole) {
        SysRole tmp = sysRoleService.update(sysRole);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        SysRole sysRole = sysRoleService.findById(id);
        return ResultGenerator.genSuccessResult(sysRole);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysRole> list = sysRoleService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @RequestMapping(value = "auth", method = RequestMethod.POST)
    public Result auth(@RequestBody RoleAuthRequest roleAuthRequest){
        if (sysRoleService.roleAuth(roleAuthRequest.getId(), roleAuthRequest.getMenus())){
            return ResultGenerator.genSuccessResult(null);
        } else {
            return ResultGenerator.genFailResult("授权失败！");
        }
    }

    @RequestMapping(value = "authlist", method = RequestMethod.POST)
    public Result authList(@RequestBody RoleAuthListRequest roleAuthListRequest){
        return ResultGenerator.genSuccessResult(sysRoleService.findAuthList(roleAuthListRequest.getRoleId()));
    }

    @RequestMapping(value = "rolelist", method = RequestMethod.POST)
    public Result roleListForUserAuth(){
        return ResultGenerator.genSuccessResult(sysRoleService.findRoleListForAuth());
    }
}
