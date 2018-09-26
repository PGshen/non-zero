package space.zero.business.module.official.website.web;

import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;
import space.zero.business.module.official.website.model.OfficialWebsiteCustomerCase;
import space.zero.business.module.official.website.service.OfficialWebsiteCustomerCaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by PG_shen on 2018/09/26.
*/
@RestController
@RequestMapping("/official/website/customer/case")
public class OfficialWebsiteCustomerCaseController {
    @Resource
    private OfficialWebsiteCustomerCaseService officialWebsiteCustomerCaseService;

    @PostMapping
    public Result add(@RequestBody OfficialWebsiteCustomerCase officialWebsiteCustomerCase) {
        OfficialWebsiteCustomerCase tmp = officialWebsiteCustomerCaseService.save(officialWebsiteCustomerCase);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        officialWebsiteCustomerCaseService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody OfficialWebsiteCustomerCase officialWebsiteCustomerCase) {
        OfficialWebsiteCustomerCase tmp = officialWebsiteCustomerCaseService.update(officialWebsiteCustomerCase);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        OfficialWebsiteCustomerCase officialWebsiteCustomerCase = officialWebsiteCustomerCaseService.findById(id);
        return ResultGenerator.genSuccessResult(officialWebsiteCustomerCase);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<OfficialWebsiteCustomerCase> list = officialWebsiteCustomerCaseService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
