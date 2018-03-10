package space.zero.business.module.sys.web;

import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;
import space.zero.business.module.sys.model.SysRoleMenu;
import space.zero.business.module.sys.service.SysRoleMenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by PG_shen on 2018/03/08.
*/
@RestController
@RequestMapping("/sys/role/menu")
public class SysRoleMenuController {
    @Resource
    private SysRoleMenuService sysRoleMenuService;

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

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysRoleMenu> list = sysRoleMenuService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
