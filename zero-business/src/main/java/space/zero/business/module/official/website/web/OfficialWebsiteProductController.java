package space.zero.business.module.official.website.web;

import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;
import space.zero.business.module.official.website.model.OfficialWebsiteProduct;
import space.zero.business.module.official.website.service.OfficialWebsiteProductService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by PG_shen on 2018/09/26.
*/
@RestController
@RequestMapping("/official/website/product")
public class OfficialWebsiteProductController {
    @Resource
    private OfficialWebsiteProductService officialWebsiteProductService;

    @PostMapping
    public Result add(@RequestBody OfficialWebsiteProduct officialWebsiteProduct) {
        OfficialWebsiteProduct tmp = officialWebsiteProductService.save(officialWebsiteProduct);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        officialWebsiteProductService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody OfficialWebsiteProduct officialWebsiteProduct) {
        OfficialWebsiteProduct tmp = officialWebsiteProductService.update(officialWebsiteProduct);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        OfficialWebsiteProduct officialWebsiteProduct = officialWebsiteProductService.findById(id);
        return ResultGenerator.genSuccessResult(officialWebsiteProduct);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<OfficialWebsiteProduct> list = officialWebsiteProductService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
