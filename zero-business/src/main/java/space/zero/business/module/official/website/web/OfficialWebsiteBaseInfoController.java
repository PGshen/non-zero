package space.zero.business.module.official.website.web;

import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;
import space.zero.business.module.official.website.model.OfficialWebsiteBaseInfo;
import space.zero.business.module.official.website.service.OfficialWebsiteBaseInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by PG_shen on 2018/09/26.
*/
@RestController
@RequestMapping("/official/website/base/info")
public class OfficialWebsiteBaseInfoController {
    @Resource
    private OfficialWebsiteBaseInfoService officialWebsiteBaseInfoService;

    @PostMapping
    public Result add(@RequestBody OfficialWebsiteBaseInfo officialWebsiteBaseInfo) {
        OfficialWebsiteBaseInfo tmp = officialWebsiteBaseInfoService.save(officialWebsiteBaseInfo);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        officialWebsiteBaseInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody OfficialWebsiteBaseInfo officialWebsiteBaseInfo) {
        OfficialWebsiteBaseInfo tmp = officialWebsiteBaseInfoService.update(officialWebsiteBaseInfo);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        OfficialWebsiteBaseInfo officialWebsiteBaseInfo = officialWebsiteBaseInfoService.findById(id);
        return ResultGenerator.genSuccessResult(officialWebsiteBaseInfo);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<OfficialWebsiteBaseInfo> list = officialWebsiteBaseInfoService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
