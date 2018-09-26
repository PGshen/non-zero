package space.zero.business.module.official.website.web;

import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;
import space.zero.business.module.official.website.model.OfficialWebsiteDigitization;
import space.zero.business.module.official.website.service.OfficialWebsiteDigitizationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by PG_shen on 2018/09/26.
*/
@RestController
@RequestMapping("/official/website/digitization")
public class OfficialWebsiteDigitizationController {
    @Resource
    private OfficialWebsiteDigitizationService officialWebsiteDigitizationService;

    @PostMapping
    public Result add(@RequestBody OfficialWebsiteDigitization officialWebsiteDigitization) {
        OfficialWebsiteDigitization tmp = officialWebsiteDigitizationService.save(officialWebsiteDigitization);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        officialWebsiteDigitizationService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody OfficialWebsiteDigitization officialWebsiteDigitization) {
        OfficialWebsiteDigitization tmp = officialWebsiteDigitizationService.update(officialWebsiteDigitization);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        OfficialWebsiteDigitization officialWebsiteDigitization = officialWebsiteDigitizationService.findById(id);
        return ResultGenerator.genSuccessResult(officialWebsiteDigitization);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<OfficialWebsiteDigitization> list = officialWebsiteDigitizationService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
