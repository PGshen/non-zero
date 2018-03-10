package space.zero.business.module.sys.web;

import space.zero.business.module.sys.param.response.SysMenuTree;
import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;
import space.zero.business.module.sys.model.SysMenu;
import space.zero.business.module.sys.service.SysMenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by PG_shen on 2018/03/08.
*/
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController {
    @Resource
    private SysMenuService sysMenuService;

//    @PostMapping
//    public Result add(@RequestBody SysMenu sysMenu) {
//        SysMenu tmp = sysMenuService.save(sysMenu);
//        return ResultGenerator.genSuccessResult(tmp);
//    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        sysMenuService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody SysMenu sysMenu) {
        SysMenu tmp = sysMenuService.update(sysMenu);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        SysMenu sysMenu = sysMenuService.findById(id);
        return ResultGenerator.genSuccessResult(sysMenu);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysMenu> list = sysMenuService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @RequestMapping(value = "tree", method = RequestMethod.POST)
    public Result getMenuTree(){
        SysMenuTree sysMenuTree = sysMenuService.getSysMenuTree();
        return ResultGenerator.genSuccessResult(sysMenuTree);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Result add(@RequestBody SysMenu menu) {
        if(null != menu) {
            if (menu.getParentId().equals("")){
                menu.setParentId("0");
            }
            sysMenuService.save(menu);
            return ResultGenerator.genSuccessResult("operation succeeded");
        } else {
            return ResultGenerator.genFailResult("menu error");
        }
    }
}
