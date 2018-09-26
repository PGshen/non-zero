package space.zero.business.module.official.website.web;

import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;
import space.zero.business.module.official.website.model.OfficialWebsiteClassMate;
import space.zero.business.module.official.website.service.OfficialWebsiteClassMateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by PG_shen on 2018/09/26.
*/
@RestController
@RequestMapping("/official/website/class/mate")
public class OfficialWebsiteClassMateController {
    @Resource
    private OfficialWebsiteClassMateService officialWebsiteClassMateService;

    @PostMapping
    public Result add(@RequestBody OfficialWebsiteClassMate officialWebsiteClassMate) {
        OfficialWebsiteClassMate tmp = officialWebsiteClassMateService.save(officialWebsiteClassMate);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        officialWebsiteClassMateService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody OfficialWebsiteClassMate officialWebsiteClassMate) {
        OfficialWebsiteClassMate tmp = officialWebsiteClassMateService.update(officialWebsiteClassMate);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        OfficialWebsiteClassMate officialWebsiteClassMate = officialWebsiteClassMateService.findById(id);
        return ResultGenerator.genSuccessResult(officialWebsiteClassMate);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<OfficialWebsiteClassMate> list = officialWebsiteClassMateService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
