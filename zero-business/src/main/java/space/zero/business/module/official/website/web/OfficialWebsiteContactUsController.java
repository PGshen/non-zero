package space.zero.business.module.official.website.web;

import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;
import space.zero.business.module.official.website.model.OfficialWebsiteContactUs;
import space.zero.business.module.official.website.service.OfficialWebsiteContactUsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by PG_shen on 2018/09/26.
*/
@RestController
@RequestMapping("/official/website/contact/us")
public class OfficialWebsiteContactUsController {
    @Resource
    private OfficialWebsiteContactUsService officialWebsiteContactUsService;

    @PostMapping
    public Result add(@RequestBody OfficialWebsiteContactUs officialWebsiteContactUs) {
        OfficialWebsiteContactUs tmp = officialWebsiteContactUsService.save(officialWebsiteContactUs);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        officialWebsiteContactUsService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody OfficialWebsiteContactUs officialWebsiteContactUs) {
        OfficialWebsiteContactUs tmp = officialWebsiteContactUsService.update(officialWebsiteContactUs);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        OfficialWebsiteContactUs officialWebsiteContactUs = officialWebsiteContactUsService.findById(id);
        return ResultGenerator.genSuccessResult(officialWebsiteContactUs);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<OfficialWebsiteContactUs> list = officialWebsiteContactUsService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
