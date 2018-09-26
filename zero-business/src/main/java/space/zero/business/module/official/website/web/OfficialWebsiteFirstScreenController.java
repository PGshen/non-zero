package space.zero.business.module.official.website.web;

import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;
import space.zero.business.module.official.website.model.OfficialWebsiteFirstScreen;
import space.zero.business.module.official.website.service.OfficialWebsiteFirstScreenService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by PG_shen on 2018/09/26.
*/
@RestController
@RequestMapping("/official/website/first/screen")
public class OfficialWebsiteFirstScreenController {
    @Resource
    private OfficialWebsiteFirstScreenService officialWebsiteFirstScreenService;

    @PostMapping
    public Result add(@RequestBody OfficialWebsiteFirstScreen officialWebsiteFirstScreen) {
        OfficialWebsiteFirstScreen tmp = officialWebsiteFirstScreenService.save(officialWebsiteFirstScreen);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        officialWebsiteFirstScreenService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody OfficialWebsiteFirstScreen officialWebsiteFirstScreen) {
        OfficialWebsiteFirstScreen tmp = officialWebsiteFirstScreenService.update(officialWebsiteFirstScreen);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        OfficialWebsiteFirstScreen officialWebsiteFirstScreen = officialWebsiteFirstScreenService.findById(id);
        return ResultGenerator.genSuccessResult(officialWebsiteFirstScreen);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<OfficialWebsiteFirstScreen> list = officialWebsiteFirstScreenService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
