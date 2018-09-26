package space.zero.business.module.official.website.web;

import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;
import space.zero.business.module.official.website.model.OfficialWebsiteAboutUs;
import space.zero.business.module.official.website.service.OfficialWebsiteAboutUsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by PG_shen on 2018/09/26.
*/
@RestController
@RequestMapping("/official/website/about/us")
public class OfficialWebsiteAboutUsController {
    @Resource
    private OfficialWebsiteAboutUsService officialWebsiteAboutUsService;

    @PostMapping
    public Result add(@RequestBody OfficialWebsiteAboutUs officialWebsiteAboutUs) {
        OfficialWebsiteAboutUs tmp = officialWebsiteAboutUsService.save(officialWebsiteAboutUs);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        officialWebsiteAboutUsService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody OfficialWebsiteAboutUs officialWebsiteAboutUs) {
        OfficialWebsiteAboutUs tmp = officialWebsiteAboutUsService.update(officialWebsiteAboutUs);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        OfficialWebsiteAboutUs officialWebsiteAboutUs = officialWebsiteAboutUsService.findById(id);
        return ResultGenerator.genSuccessResult(officialWebsiteAboutUs);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<OfficialWebsiteAboutUs> list = officialWebsiteAboutUsService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
