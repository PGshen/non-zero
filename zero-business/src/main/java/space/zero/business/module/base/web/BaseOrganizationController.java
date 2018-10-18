package space.zero.business.module.base.web;

import space.zero.business.module.base.param.response.BaseOrganizationTree;
import space.zero.business.module.sys.param.request.CondRequest;
import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;
import space.zero.business.module.base.model.BaseOrganization;
import space.zero.business.module.base.service.BaseOrganizationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by PG_shen on 2018/03/17.
*/
@RestController
@RequestMapping("/base/org")
public class BaseOrganizationController {
    @Resource
    private BaseOrganizationService baseOrganizationService;

    @PostMapping
    public Result add(@RequestBody BaseOrganization baseOrganization) {
        if (null != baseOrganization){
            if (baseOrganization.getParentId().equals("")){
                baseOrganization.setParentId("0");
            }
            BaseOrganization tmp = baseOrganizationService.save(baseOrganization);
            return ResultGenerator.genSuccessResult("operation succeeded");
        }else {
            return ResultGenerator.genSuccessResult("operation fail");
        }
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        baseOrganizationService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody BaseOrganization baseOrganization) {
        BaseOrganization tmp = baseOrganizationService.update(baseOrganization);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        BaseOrganization baseOrganization = baseOrganizationService.findById(id);
        return ResultGenerator.genSuccessResult(baseOrganization);
    }

    @PostMapping("list")
    public Result list(@RequestBody CondRequest condRequest) {
        PageHelper.startPage(condRequest.getPage(), condRequest.getSize(), condRequest.getOrder());
        List<BaseOrganization> list = baseOrganizationService.findBy(condRequest.getCond());
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.setOrderBy(condRequest.getOrder());
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping("tree")
    public Result getOrgTree(){
        BaseOrganizationTree organizationTree = baseOrganizationService.getOrgTree();
        return ResultGenerator.genSuccessResult(organizationTree.getChildren());
    }

    @GetMapping("/page")
    public Result page(){
        return ResultGenerator.genSuccessResult();
    }
}
