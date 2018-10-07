package space.zero.business.module.official.website.web;

import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import space.zero.common.utils.FileUploadEnum;
import space.zero.common.utils.FileUploadUtils;
import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;
import space.zero.business.module.official.website.model.OfficialWebsiteBaseInfo;
import space.zero.business.module.official.website.service.OfficialWebsiteBaseInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
* Created by PG_shen on 2018/09/26.
*/
@RestController
@RequestMapping("/official/website/base/info")
public class OfficialWebsiteBaseInfoController {
    @Resource
    private OfficialWebsiteBaseInfoService officialWebsiteBaseInfoService;

    @PutMapping
    public Result update(@RequestBody OfficialWebsiteBaseInfo officialWebsiteBaseInfo) {
        officialWebsiteBaseInfo.setLogoUrl(officialWebsiteBaseInfo.getLogoUrl().replace("http://localhost:8088/",""));
        officialWebsiteBaseInfo.setQrCodeUrl(officialWebsiteBaseInfo.getQrCodeUrl().replace("http://localhost:8088/",""));
        OfficialWebsiteBaseInfo baseInfo = officialWebsiteBaseInfoService.updateInfo(officialWebsiteBaseInfo);
        officialWebsiteBaseInfo.setLogoUrl("http://localhost:8088/"+ officialWebsiteBaseInfo.getLogoUrl());
        officialWebsiteBaseInfo.setQrCodeUrl("http://localhost:8088/" + officialWebsiteBaseInfo.getQrCodeUrl());
        return ResultGenerator.genSuccessResult(baseInfo);
    }

    @GetMapping
    public Result detail() {
        OfficialWebsiteBaseInfo officialWebsiteBaseInfo = officialWebsiteBaseInfoService.fetchInfo();
        officialWebsiteBaseInfo.setLogoUrl("http://localhost:8088/"+ officialWebsiteBaseInfo.getLogoUrl());
        officialWebsiteBaseInfo.setQrCodeUrl("http://localhost:8088/" + officialWebsiteBaseInfo.getQrCodeUrl());
        return ResultGenerator.genSuccessResult(officialWebsiteBaseInfo);
    }

    /**
     * 文件上传
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public Result upload(@RequestParam("avatar") MultipartFile file){
        FileUploadUtils fileUploadUtils = new FileUploadUtils();
        String filePath = null;
        try {
            filePath = "http://localhost:8088/" + fileUploadUtils.uploadFile(file, FileUploadEnum.AVATAR);
        } catch (IOException e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult("fail");
        }
        return ResultGenerator.genSuccessResult(filePath, "success");
    }
}
