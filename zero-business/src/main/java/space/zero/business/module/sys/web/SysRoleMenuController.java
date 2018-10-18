package space.zero.business.module.sys.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import space.zero.business.module.sys.dao.SysUserMapper;
import space.zero.business.module.sys.model.SysRole;
import space.zero.business.module.sys.model.SysUserDetails;
import space.zero.business.module.sys.param.request.CondRequest;
import space.zero.business.module.sys.param.response.RouterTree;
import space.zero.business.module.sys.service.SysMenuService;
import space.zero.business.module.sys.service.SysRoleService;
import space.zero.business.module.sys.service.SysUserRoleService;
import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;
import space.zero.business.module.sys.model.SysRoleMenu;
import space.zero.business.module.sys.service.SysRoleMenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.sound.midi.SysexMessage;
import java.util.List;

/**
* Created by PG_shen on 2018/03/08.
*/
@RestController
@RequestMapping("/sys/role/menu")
public class SysRoleMenuController {
    @Resource
    private SysRoleMenuService sysRoleMenuService;
    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private SysUserRoleService sysUserRoleService;

    @PostMapping
    public Result add(@RequestBody SysRoleMenu sysRoleMenu) {
        SysRoleMenu tmp = sysRoleMenuService.save(sysRoleMenu);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        sysRoleMenuService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody SysRoleMenu sysRoleMenu) {
        SysRoleMenu tmp = sysRoleMenuService.update(sysRoleMenu);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        SysRoleMenu sysRoleMenu = sysRoleMenuService.findById(id);
        return ResultGenerator.genSuccessResult(sysRoleMenu);
    }

//    @GetMapping
//    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
//        PageHelper.startPage(page, size);
//        List<SysRoleMenu> list = sysRoleMenuService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultGenerator.genSuccessResult(pageInfo);
//    }

    @PostMapping("/list")
    public Result list(@RequestBody CondRequest condRequest){
        PageHelper.startPage(condRequest.getPage(), condRequest.getSize(), condRequest.getOrder());
        List<SysRoleMenu> list = sysRoleMenuService.findBy(condRequest.getCond());
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.setOrderBy(condRequest.getOrder());
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping("/tree")
    public Result tree(){
        SysUserDetails sysUserDetails = (SysUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<String> roles = sysUserRoleService.getRoleByUserId(sysUserDetails.getUser().getId());
        List<RouterTree> routerTrees = sysMenuService.getMenuByRoles(roles);
        return ResultGenerator.genSuccessResult(routerTrees);
    }

    @GetMapping("/getPerms")
    public Result getPerms(){
        return ResultGenerator.genSuccessResult(sysRoleMenuService.getPermsByRoles());
    }

    @GetMapping("/page")
    public Result page(){
        return ResultGenerator.genSuccessResult();
    }
}
