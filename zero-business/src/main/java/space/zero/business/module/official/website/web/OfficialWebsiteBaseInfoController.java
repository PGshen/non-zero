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

    @Resource
    private ResourceLoader resourceLoader;

    @PostMapping
    public Result add(@RequestBody OfficialWebsiteBaseInfo officialWebsiteBaseInfo) {
        OfficialWebsiteBaseInfo tmp = officialWebsiteBaseInfoService.save(officialWebsiteBaseInfo);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        officialWebsiteBaseInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody OfficialWebsiteBaseInfo officialWebsiteBaseInfo) {
        OfficialWebsiteBaseInfo tmp = officialWebsiteBaseInfoService.update(officialWebsiteBaseInfo);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        OfficialWebsiteBaseInfo officialWebsiteBaseInfo = officialWebsiteBaseInfoService.findById(id);
        return ResultGenerator.genSuccessResult(officialWebsiteBaseInfo);
    }

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<OfficialWebsiteBaseInfo> list = officialWebsiteBaseInfoService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 文件上传
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public Result upload(@RequestParam("fileName") MultipartFile file){
        FileUploadUtils fileUploadUtils = new FileUploadUtils();
        String filePath = null;
        try {
            filePath = fileUploadUtils.uploadFile(file, FileUploadEnum.FILE);
        } catch (IOException e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult("fail");
        }
        return ResultGenerator.genSuccessResult(filePath, "success");
    }

    /**
     *
     * https://blog.csdn.net/qq_32106647/article/details/80519262
     * @param fileName
     * @return
     */
    @RequestMapping("show")
    public ResponseEntity showPhotos(String fileName){

        try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            return ResponseEntity.ok(resourceLoader.getResource("file:" + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
