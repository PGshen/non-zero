package space.zero.business.module.official.website.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;
import space.zero.business.module.official.website.param.request.CondRequest;
import space.zero.common.utils.FileUploadEnum;
import space.zero.common.utils.FileUploadUtils;
import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;
import space.zero.business.module.official.website.model.OfficialWebsiteContactUs;
import space.zero.business.module.official.website.service.OfficialWebsiteContactUsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import static space.zero.core.constant.Constant.ENABLE_FLAG_FALSE;
import static space.zero.core.constant.Constant.ENABLE_FLAG_TRUE;

/**
* Created by PG_shen on 2018/09/26.
*/
@RestController
@RequestMapping("/official/website/contact/us")
public class OfficialWebsiteContactUsController {
    @Resource
    private OfficialWebsiteContactUsService officialWebsiteContactUsService;
    @Value("${website.global.host}")
    private String host;

    @PostMapping
    public Result add(@RequestBody OfficialWebsiteContactUs officialWebsiteContactUs) {
        officialWebsiteContactUs.setPic(officialWebsiteContactUs.getPic().replace(host, ""));
        OfficialWebsiteContactUs tmp = officialWebsiteContactUsService.save(officialWebsiteContactUs);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        officialWebsiteContactUsService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody OfficialWebsiteContactUs officialWebsiteContactUs) {
        officialWebsiteContactUs.setPic(officialWebsiteContactUs.getPic().replace(host, ""));
        OfficialWebsiteContactUs tmp = officialWebsiteContactUsService.update(officialWebsiteContactUs);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        OfficialWebsiteContactUs officialWebsiteContactUs = officialWebsiteContactUsService.findById(id);
        return ResultGenerator.genSuccessResult(officialWebsiteContactUs);
    }

    @PostMapping("/checkout/{id}")
    public Result checkoutStatus(@PathVariable String id){
        OfficialWebsiteContactUs contactUs = officialWebsiteContactUsService.findById(id);
        if (ENABLE_FLAG_TRUE.equals(contactUs.getIsEnable())){
            contactUs.setIsEnable(ENABLE_FLAG_FALSE);
        }else if (ENABLE_FLAG_FALSE.equals(contactUs.getIsEnable())){
            contactUs.setIsEnable(ENABLE_FLAG_TRUE);
        }
        officialWebsiteContactUsService.update(contactUs);
        return ResultGenerator.genSuccessResult(contactUs);
    }

    @PostMapping("/list")
    public Result list(@RequestBody CondRequest condRequest) {
        PageHelper.startPage(condRequest.getPage(), condRequest.getSize(), condRequest.getOrder());
        Iterator<String> iterator = condRequest.getCond().keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            if ("isEnable".equals(key) && condRequest.getCond().get(key).equals("-1")){
                iterator.remove();
            }
            if ("name".equals(key) && condRequest.getCond().get(key).equals("")){
                iterator.remove();
            }
        }
        List<OfficialWebsiteContactUs> list = officialWebsiteContactUsService.findBy(condRequest.getCond());
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.setOrderBy(condRequest.getOrder());
        pageInfo.getList().forEach(item ->{
            OfficialWebsiteContactUs contactUs = (OfficialWebsiteContactUs) item;
            contactUs.setPic(host+contactUs.getPic());
        });
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file){
        FileUploadUtils fileUploadUtils = new FileUploadUtils();
        String filePath = null;
        try {
            filePath = host + fileUploadUtils.uploadFile(file, FileUploadEnum.CAROUSEL);
        } catch (IOException e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult("fail");
        }
        return ResultGenerator.genSuccessResult(filePath, "success");
    }
}
