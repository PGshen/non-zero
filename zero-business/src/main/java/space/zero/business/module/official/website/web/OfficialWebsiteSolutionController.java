package space.zero.business.module.official.website.web;

import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;
import space.zero.business.module.official.website.model.OfficialWebsiteSolution;
import space.zero.business.module.official.website.service.OfficialWebsiteSolutionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by PG_shen on 2018/09/26.
*/
@RestController
@RequestMapping("/official/website/solution")
public class OfficialWebsiteSolutionController {
    @Resource
    private OfficialWebsiteSolutionService officialWebsiteSolutionService;

    @PostMapping
    public Result add(@RequestBody OfficialWebsiteSolution officialWebsiteSolution) {
        OfficialWebsiteSolution tmp = officialWebsiteSolutionService.save(officialWebsiteSolution);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        officialWebsiteSolutionService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody OfficialWebsiteSolution officialWebsiteSolution) {
        OfficialWebsiteSolution tmp = officialWebsiteSolutionService.update(officialWebsiteSolution);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        OfficialWebsiteSolution officialWebsiteSolution = officialWebsiteSolutionService.findById(id);
        return ResultGenerator.genSuccessResult(officialWebsiteSolution);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<OfficialWebsiteSolution> list = officialWebsiteSolutionService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
