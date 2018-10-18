package space.zero.business.module.official.website.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;
import space.zero.common.utils.FileUploadEnum;
import space.zero.common.utils.FileUploadUtils;
import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;
import space.zero.business.module.official.website.model.OfficialWebsiteBaseInfo;
import space.zero.business.module.official.website.service.OfficialWebsiteBaseInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

/**
* Created by PG_shen on 2018/09/26.
*/
@RestController
@RequestMapping("/official/website/base/info")
public class OfficialWebsiteBaseInfoController {
    @Resource
    private OfficialWebsiteBaseInfoService officialWebsiteBaseInfoService;
    @Value("${website.global.host}")
    private String host;

    @PutMapping
    public Result update(@RequestBody OfficialWebsiteBaseInfo officialWebsiteBaseInfo) {
        officialWebsiteBaseInfo.setLogoUrl(officialWebsiteBaseInfo.getLogoUrl().replace(host,""));
        officialWebsiteBaseInfo.setQrCodeUrl(officialWebsiteBaseInfo.getQrCodeUrl().replace(host,""));
        OfficialWebsiteBaseInfo baseInfo = officialWebsiteBaseInfoService.updateInfo(officialWebsiteBaseInfo);
        officialWebsiteBaseInfo.setLogoUrl(host+ officialWebsiteBaseInfo.getLogoUrl());
        officialWebsiteBaseInfo.setQrCodeUrl(host + officialWebsiteBaseInfo.getQrCodeUrl());
        return ResultGenerator.genSuccessResult(baseInfo);
    }

    @GetMapping
    public Result detail() {
        OfficialWebsiteBaseInfo officialWebsiteBaseInfo = officialWebsiteBaseInfoService.fetchInfo();
        officialWebsiteBaseInfo.setLogoUrl(host+ officialWebsiteBaseInfo.getLogoUrl());
        officialWebsiteBaseInfo.setQrCodeUrl(host + officialWebsiteBaseInfo.getQrCodeUrl());
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
            filePath = host + fileUploadUtils.uploadFile(file, FileUploadEnum.AVATAR);
        } catch (IOException e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult("fail");
        }
        return ResultGenerator.genSuccessResult(filePath, "success");
    }
}
