package space.zero.business.module.official.website.web;

import space.zero.business.module.official.website.param.request.ClazzListRequest;
import space.zero.business.module.official.website.param.request.CondRequest;
import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;
import space.zero.business.module.official.website.model.OfficialWebsiteClassMate;
import space.zero.business.module.official.website.service.OfficialWebsiteClassMateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static space.zero.core.constant.Constant.ENABLE_FLAG_FALSE;
import static space.zero.core.constant.Constant.ENABLE_FLAG_TRUE;

/**
* Created by PG_shen on 2018/10/04.
*/
@RestController
@RequestMapping("/official/website/class/mate")
public class OfficialWebsiteClassMateController {
    @Resource
    private OfficialWebsiteClassMateService officialWebsiteClassMateService;

    @PostMapping
    public Result add(@RequestBody OfficialWebsiteClassMate officialWebsiteClassMate) {
        OfficialWebsiteClassMate tmp = officialWebsiteClassMateService.save(officialWebsiteClassMate);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        officialWebsiteClassMateService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody OfficialWebsiteClassMate officialWebsiteClassMate) {
        OfficialWebsiteClassMate tmp = officialWebsiteClassMateService.update(officialWebsiteClassMate);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        OfficialWebsiteClassMate officialWebsiteClassMate = officialWebsiteClassMateService.findById(id);
        return ResultGenerator.genSuccessResult(officialWebsiteClassMate);
    }

    @PostMapping("/list")
    public Result list(@RequestBody CondRequest condRequest) {
        PageHelper.startPage(condRequest.getPage(), condRequest.getSize(), condRequest.getOrder());
        List<OfficialWebsiteClassMate> list = officialWebsiteClassMateService.findBy(condRequest.getCond());
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping("/clazzlist")
    public Result clazzList(@RequestBody ClazzListRequest clazzListRequest){
        return ResultGenerator.genSuccessResult(officialWebsiteClassMateService.findClazz(clazzListRequest.getClazzName()));
    }

    @PostMapping("/checkout/{id}")
    public Result checkoutStatus(@PathVariable String id){
        OfficialWebsiteClassMate classMate = officialWebsiteClassMateService.findById(id);
        if ("1".equals(classMate.getIsEnable())){
            classMate.setIsEnable(ENABLE_FLAG_FALSE);
        }else if ("0".equals(classMate.getIsEnable())){
            classMate.setIsEnable(ENABLE_FLAG_TRUE);
        }
        officialWebsiteClassMateService.update(classMate);
        return ResultGenerator.genSuccessResult(classMate);
    }
}
