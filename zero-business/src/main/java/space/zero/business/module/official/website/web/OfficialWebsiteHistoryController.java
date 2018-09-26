package space.zero.business.module.official.website.web;

import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;
import space.zero.business.module.official.website.model.OfficialWebsiteHistory;
import space.zero.business.module.official.website.service.OfficialWebsiteHistoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by PG_shen on 2018/09/26.
*/
@RestController
@RequestMapping("/official/website/history")
public class OfficialWebsiteHistoryController {
    @Resource
    private OfficialWebsiteHistoryService officialWebsiteHistoryService;

    @PostMapping
    public Result add(@RequestBody OfficialWebsiteHistory officialWebsiteHistory) {
        OfficialWebsiteHistory tmp = officialWebsiteHistoryService.save(officialWebsiteHistory);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        officialWebsiteHistoryService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody OfficialWebsiteHistory officialWebsiteHistory) {
        OfficialWebsiteHistory tmp = officialWebsiteHistoryService.update(officialWebsiteHistory);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        OfficialWebsiteHistory officialWebsiteHistory = officialWebsiteHistoryService.findById(id);
        return ResultGenerator.genSuccessResult(officialWebsiteHistory);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<OfficialWebsiteHistory> list = officialWebsiteHistoryService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
