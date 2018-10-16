package space.zero.business.module.official.website.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;
import space.zero.business.module.official.website.param.request.CondRequest;
import space.zero.business.module.official.website.param.response.ClazzListResponse;
import space.zero.business.module.official.website.service.OfficialWebsiteClassMateService;
import space.zero.common.utils.FileUploadEnum;
import space.zero.common.utils.FileUploadUtils;
import space.zero.common.utils.StringUtils;
import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;
import space.zero.business.module.official.website.model.OfficialWebsiteCustomerCase;
import space.zero.business.module.official.website.service.OfficialWebsiteCustomerCaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static space.zero.core.constant.Constant.ENABLE_FLAG_FALSE;
import static space.zero.core.constant.Constant.ENABLE_FLAG_TRUE;

/**
* Created by PG_shen on 2018/09/26.
*/
@RestController
@RequestMapping("/official/website/customer/case")
public class OfficialWebsiteCustomerCaseController {
    @Resource
    private OfficialWebsiteCustomerCaseService officialWebsiteCustomerCaseService;
    @Resource
    private OfficialWebsiteClassMateService classMateService;
    @Value("${website.global.host}")
    private String host;

    @PostMapping
    public Result add(@RequestBody OfficialWebsiteCustomerCase officialWebsiteCustomerCase) {
        officialWebsiteCustomerCase.setCasePic(officialWebsiteCustomerCase.getCasePic().replace(host,""));
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
        officialWebsiteCustomerCase.setCasePic(officialWebsiteCustomerCase.getCasePic().replace(host,""));
        OfficialWebsiteCustomerCase tmp = officialWebsiteCustomerCaseService.update(officialWebsiteCustomerCase);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        OfficialWebsiteCustomerCase officialWebsiteCustomerCase = officialWebsiteCustomerCaseService.findById(id);
        officialWebsiteCustomerCase.setCasePic(host+officialWebsiteCustomerCase.getCasePic());
        return ResultGenerator.genSuccessResult(officialWebsiteCustomerCase);
    }

    @PostMapping("list")
    public Result list(@RequestBody CondRequest condRequest) {
        PageHelper.startPage(condRequest.getPage(), condRequest.getSize(), condRequest.getOrder());
        Iterator<String> iterator = condRequest.getCond().keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            if ("isEnable".equals(key) && (condRequest.getCond().get(key).equals("-1") || condRequest.getCond().equals(""))){
                iterator.remove();
            }
            if ("firstHeading".equals(key) && condRequest.getCond().get(key).equals("")){
                iterator.remove();
            }
        }
        List<OfficialWebsiteCustomerCase> list = officialWebsiteCustomerCaseService.findBy(condRequest.getCond());
//        获取所有的类别,并转成map
        List<ClazzListResponse> customerCaseClazz = classMateService.findClazz("CASE");
        Map<String, String> customerCaseClazzMap = customerCaseClazz.stream().collect(Collectors.toMap(ClazzListResponse::getId, ClazzListResponse::getClazzValue,(k1, k2)->k1));
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.getList().forEach(item ->{
            OfficialWebsiteCustomerCase customerCase = (OfficialWebsiteCustomerCase) item;
            customerCase.setCasePic(host+customerCase.getCasePic());
            customerCase.setCaseClass(customerCaseClazzMap.get(customerCase.getCaseClass()));
        });
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping("/checkout/{id}")
    public Result checkoutStatus(@PathVariable String id){
        OfficialWebsiteCustomerCase customerCase = officialWebsiteCustomerCaseService.findById(id);
        if (ENABLE_FLAG_FALSE.equals(customerCase.getIsEnable())){
            customerCase.setIsEnable(ENABLE_FLAG_TRUE);
        }else if (ENABLE_FLAG_TRUE.equals(customerCase.getIsEnable())){
            customerCase.setIsEnable(ENABLE_FLAG_FALSE);
        }
        officialWebsiteCustomerCaseService.update(customerCase);
        return ResultGenerator.genSuccessResult(customerCase);
    }

    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file){
        FileUploadUtils fileUploadUtils = new FileUploadUtils();
        String filePath = null;
        try {
            filePath = host + fileUploadUtils.uploadFile(file, FileUploadEnum.CUSTOMERCASE);
        } catch (IOException e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult("fail");
        }
        return ResultGenerator.genSuccessResult(filePath, "success");
    }
}
