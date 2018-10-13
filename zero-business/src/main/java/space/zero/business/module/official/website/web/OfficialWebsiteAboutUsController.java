package space.zero.business.module.official.website.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;
import space.zero.business.module.official.website.param.request.CondRequest;
import space.zero.common.utils.FileUploadEnum;
import space.zero.common.utils.FileUploadUtils;
import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;
import space.zero.business.module.official.website.model.OfficialWebsiteAboutUs;
import space.zero.business.module.official.website.service.OfficialWebsiteAboutUsService;
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
@RequestMapping("/official/website/about/us")
public class OfficialWebsiteAboutUsController {
    @Resource
    private OfficialWebsiteAboutUsService officialWebsiteAboutUsService;
    @Value("${website.global.host}")
    private String host;

    @PostMapping
    public Result add(@RequestBody OfficialWebsiteAboutUs officialWebsiteAboutUs) {
        officialWebsiteAboutUs.setPic(officialWebsiteAboutUs.getPic().replace(host, ""));
        OfficialWebsiteAboutUs tmp = officialWebsiteAboutUsService.save(officialWebsiteAboutUs);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        officialWebsiteAboutUsService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody OfficialWebsiteAboutUs officialWebsiteAboutUs) {
        officialWebsiteAboutUs.setPic(officialWebsiteAboutUs.getPic().replace(host, ""));
        OfficialWebsiteAboutUs tmp = officialWebsiteAboutUsService.update(officialWebsiteAboutUs);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        OfficialWebsiteAboutUs officialWebsiteAboutUs = officialWebsiteAboutUsService.findById(id);
        return ResultGenerator.genSuccessResult(officialWebsiteAboutUs);
    }

    @PostMapping("/list")
    public Result list(@RequestBody CondRequest condRequest) {
        PageHelper.startPage(condRequest.getPage(), condRequest.getSize());
        Iterator<String> iterator = condRequest.getCond().keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            if ("isEnable".equals(key) && condRequest.getCond().get(key).equals("-1")){
                iterator.remove();
            }
        }
        List<OfficialWebsiteAboutUs> list = officialWebsiteAboutUsService.findBy(condRequest.getCond());
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.getList().forEach(item -> {
            OfficialWebsiteAboutUs aboutUs = (OfficialWebsiteAboutUs)item;
            aboutUs.setPic(host + aboutUs.getPic());
        });
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 一种类别只能有一个处于启用状态
     * @param id
     * @return
     */
    @PostMapping("/checkout/{id}")
    public Result checkoutStatus(@PathVariable String id){
        OfficialWebsiteAboutUs aboutUs = officialWebsiteAboutUsService.findById(id);
        // TODO 一种类别只能有一个处于启用状态
        if (ENABLE_FLAG_TRUE.equals(aboutUs.getIsEnable())){
            aboutUs.setIsEnable(ENABLE_FLAG_FALSE);
        }else if (ENABLE_FLAG_FALSE.equals(aboutUs.getIsEnable())){
            aboutUs.setIsEnable(ENABLE_FLAG_TRUE);
        }
        officialWebsiteAboutUsService.update(aboutUs);
        return ResultGenerator.genSuccessResult(aboutUs);
    }

    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file){
        FileUploadUtils fileUploadUtils = new FileUploadUtils();
        String filePath = null;
        try {
            filePath = host + fileUploadUtils.uploadFile(file, FileUploadEnum.ABOUTUS);
        } catch (IOException e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult("fail");
        }
        return ResultGenerator.genSuccessResult(filePath, "success");
    }
}
