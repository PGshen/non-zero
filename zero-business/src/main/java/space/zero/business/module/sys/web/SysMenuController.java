package space.zero.business.module.sys.web;

import space.zero.business.module.sys.param.request.CondRequest;
import space.zero.business.module.sys.param.response.SysMenuTree;
import space.zero.core.mapper.Mapper;
import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;
import space.zero.business.module.sys.model.SysMenu;
import space.zero.business.module.sys.service.SysMenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
* Created by PG_shen on 2018/03/08.
*/
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController {
    @Resource
    private SysMenuService sysMenuService;

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

//    @GetMapping
//    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size, @RequestParam(defaultValue = "id") String order, @RequestParam Map<String, String> condition) {
//        PageHelper.startPage(page, size);
//        List<SysMenu> list = sysMenuService.findBy(condition);
//        PageInfo pageInfo = new PageInfo(list);
//        pageInfo.setOrderBy(order);
//        return ResultGenerator.genSuccessResult(pageInfo);
//    }

    @PostMapping("/list")
    public Result list(@RequestBody CondRequest condRequest){
        PageHelper.startPage(condRequest.getPage(), condRequest.getSize());
        List<SysMenu> list = sysMenuService.findBy(condRequest.getCond());
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.setOrderBy(condRequest.getOrder());
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @RequestMapping(value = "tree", method = RequestMethod.POST)
    public Result getMenuTree(){
        SysMenuTree sysMenuTree = sysMenuService.getSysMenuTree();
        return ResultGenerator.genSuccessResult(sysMenuTree);
    }

    @PostMapping
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
