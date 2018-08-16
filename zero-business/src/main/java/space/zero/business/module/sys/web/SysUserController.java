package space.zero.business.module.sys.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import space.zero.business.module.sys.model.SysUserDetails;
import space.zero.business.module.sys.param.request.CondRequest;
import space.zero.business.module.sys.param.request.SysUserListRequest;
import space.zero.business.module.sys.param.request.UserRoleListRequest;
import space.zero.business.module.sys.service.SysUserRoleService;
import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;
import space.zero.business.module.sys.model.SysUser;
import space.zero.business.module.sys.service.SysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Created by PG_shen on 2018/03/08.
*/
@RestController
@RequestMapping("/sys/user")
public class SysUserController {
    @Resource
    private SysUserService sysUserService;
    @Autowired
    private SysUserRoleService sysUserRoleService;

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        sysUserService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        SysUser sysUser = sysUserService.findById(id);
        return ResultGenerator.genSuccessResult(sysUser);
    }

//    @GetMapping
//    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
//        PageHelper.startPage(page, size);
//        List<SysUser> list = sysUserService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultGenerator.genSuccessResult(pageInfo);
//    }

    @PostMapping("/list")
    public Result list(@RequestBody CondRequest condRequest){
        PageHelper.startPage(condRequest.getPage(), condRequest.getSize());
        List<SysUser> list = sysUserService.findBy(condRequest.getCond());
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.setOrderBy(condRequest.getOrder());
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @RequestMapping(value="nowUser" ,method = RequestMethod.POST)
    public Result nowUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(principal);
        if(principal!=null){

            if(principal instanceof SysUserDetails){
                SysUserDetails userDetail = (SysUserDetails) principal;
                SysUser sysUser = userDetail.getUser();
//                List<String> role = new ArrayList<>();
//                List<String> roles = sysUserRoleRepository.getSysRolesByUsername(sysUser.getName());
//                user.setRole(roles);

//                sysUser.setRole(roles);
//                return ResponseMessage    .newOkInstance(userDetail.getUser());
                return ResultGenerator.genSuccessResult(sysUser);
            }else {
                return ResultGenerator.genSuccessResult(principal.toString());
            }

        }else{
            return ResultGenerator.genForbiddenInterfaceResult(null, "can not get user bind to this token");
        }

    }


    @PostMapping
    public Result add(@RequestBody SysUser user) {
        List<SysUser> existUser = sysUserService.findBy("loginName",user.getLoginName());
        if(existUser.size() == 0) {
            sysUserService.save(user);
            //添加用户角色
            sysUserRoleService.addRoles(user.getId(), user.getRole());
            return ResultGenerator.genSuccessResult("operation succeeded");
        } else {
            return ResultGenerator.genFailResult("user already exist");
        }
    }

    @PutMapping
    public Result update(@RequestBody SysUser user) {
//        SysUser existUser = sysUserService.getByLoginName(user.getLoginName());
        SysUser existUser = sysUserService.findById(user.getId());
        if(null != existUser) {
            sysUserService.update(user);
            sysUserRoleService.updateRoles(user.getId(), user.getRole());
            return ResultGenerator.genSuccessResult("operation succeeded");
        } else {
            return ResultGenerator.genFailResult("user doesn't exist");
        }
    }

    @RequestMapping(value = "userrolelist", method = RequestMethod.POST)
    public Result roleList(@RequestBody UserRoleListRequest userRoleListRequest){
        return ResultGenerator.genSuccessResult(sysUserService.findUserRoleList(userRoleListRequest.getUserId()));
    }

    @GetMapping("/page")
    public Result page(){
        return ResultGenerator.genSuccessResult();
    }
}
