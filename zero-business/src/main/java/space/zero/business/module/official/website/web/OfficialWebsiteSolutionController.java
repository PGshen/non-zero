package space.zero.business.module.official.website.web;

import org.springframework.web.multipart.MultipartFile;
import space.zero.business.module.official.website.param.request.CondRequest;
import space.zero.business.module.official.website.param.response.ClazzListResponse;
import space.zero.business.module.official.website.service.OfficialWebsiteClassMateService;
import space.zero.common.utils.FileUploadEnum;
import space.zero.common.utils.FileUploadUtils;
import space.zero.common.utils.StringUtils;
import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;
import space.zero.business.module.official.website.model.OfficialWebsiteSolution;
import space.zero.business.module.official.website.service.OfficialWebsiteSolutionService;
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
@RequestMapping("/official/website/solution")
public class OfficialWebsiteSolutionController {
    @Resource
    private OfficialWebsiteSolutionService officialWebsiteSolutionService;
    @Resource
    private OfficialWebsiteClassMateService classMateService;

    @PostMapping
    public Result add(@RequestBody OfficialWebsiteSolution officialWebsiteSolution) {
        officialWebsiteSolution.setSolutionPic(officialWebsiteSolution.getSolutionPic().replace("http://localhost:8088/",""));
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
        officialWebsiteSolution.setSolutionPic(officialWebsiteSolution.getSolutionPic().replace("http://localhost:8088/",""));
        OfficialWebsiteSolution tmp = officialWebsiteSolutionService.update(officialWebsiteSolution);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        OfficialWebsiteSolution officialWebsiteSolution = officialWebsiteSolutionService.findById(id);
        officialWebsiteSolution.setSolutionPic("http://localhost:8088/" + officialWebsiteSolution.getSolutionPic());
        return ResultGenerator.genSuccessResult(officialWebsiteSolution);
    }

    @PostMapping("/list")
    public Result list(@RequestBody CondRequest condRequest) {
        PageHelper.startPage(condRequest.getPage(), condRequest.getSize(), StringUtils.HumpToUnderline(condRequest.getOrder()) + " desc");
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
        List<OfficialWebsiteSolution> list = officialWebsiteSolutionService.findBy(condRequest.getCond());
//        获取所有的类别,并转成map
        List<ClazzListResponse> solutionClazz = classMateService.findClazz("SOLUTION");
        Map<String, String> solutionClazzMap = solutionClazz.stream().collect(Collectors.toMap(ClazzListResponse::getId, ClazzListResponse::getClazzValue,(k1, k2)->k1));
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.getList().forEach(item ->{
            OfficialWebsiteSolution solution = (OfficialWebsiteSolution) item;
            solution.setSolutionPic("http://localhost:8088/"+solution.getSolutionPic());
            solution.setSolutionClass(solutionClazzMap.get(solution.getSolutionClass()));
        });
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping("/checkout/{id}")
    public Result checkoutStatus(@PathVariable String id){
        OfficialWebsiteSolution solution = officialWebsiteSolutionService.findById(id);
        if (ENABLE_FLAG_FALSE.equals(solution.getIsEnable())){
            solution.setIsEnable(ENABLE_FLAG_TRUE);
        }else if (ENABLE_FLAG_TRUE.equals(solution.getIsEnable())){
            solution.setIsEnable(ENABLE_FLAG_FALSE);
        }
        officialWebsiteSolutionService.update(solution);
        return ResultGenerator.genSuccessResult(solution);
    }

    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file){
        FileUploadUtils fileUploadUtils = new FileUploadUtils();
        String filePath = null;
        try {
            filePath = "http://localhost:8088/" + fileUploadUtils.uploadFile(file, FileUploadEnum.SOLUTION);
        } catch (IOException e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult("fail");
        }
        return ResultGenerator.genSuccessResult(filePath, "success");
    }
}
