package space.zero.business.module.base.web;

import space.zero.business.module.base.model.BaseLog;
import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;
import space.zero.business.module.base.service.BaseLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by PG_shen on 2018/08/19.
*/
@RestController
@RequestMapping("/base/log")
public class BaseLogController {
    @Resource
    private BaseLogService baseLogService;

    @PostMapping
    public Result add(@RequestBody BaseLog baseLog) {
        BaseLog tmp = baseLogService.save(baseLog);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        baseLogService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody BaseLog baseLog) {
        BaseLog tmp = baseLogService.update(baseLog);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        BaseLog baseLog = baseLogService.findById(id);
        return ResultGenerator.genSuccessResult(baseLog);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<BaseLog> list = baseLogService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
