package space.zero.business.module.official.website.web;

import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;
import space.zero.business.module.official.website.model.OfficialWebsiteRecruit;
import space.zero.business.module.official.website.service.OfficialWebsiteRecruitService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by PG_shen on 2018/09/26.
*/
@RestController
@RequestMapping("/official/website/recruit")
public class OfficialWebsiteRecruitController {
    @Resource
    private OfficialWebsiteRecruitService officialWebsiteRecruitService;

    @PostMapping
    public Result add(@RequestBody OfficialWebsiteRecruit officialWebsiteRecruit) {
        OfficialWebsiteRecruit tmp = officialWebsiteRecruitService.save(officialWebsiteRecruit);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        officialWebsiteRecruitService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody OfficialWebsiteRecruit officialWebsiteRecruit) {
        OfficialWebsiteRecruit tmp = officialWebsiteRecruitService.update(officialWebsiteRecruit);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        OfficialWebsiteRecruit officialWebsiteRecruit = officialWebsiteRecruitService.findById(id);
        return ResultGenerator.genSuccessResult(officialWebsiteRecruit);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<OfficialWebsiteRecruit> list = officialWebsiteRecruitService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
