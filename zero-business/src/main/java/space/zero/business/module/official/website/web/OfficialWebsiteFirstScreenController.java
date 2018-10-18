package space.zero.business.module.official.website.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;
import space.zero.business.module.official.website.param.request.CondRequest;
import space.zero.common.utils.FileUploadEnum;
import space.zero.common.utils.FileUploadUtils;
import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;
import space.zero.business.module.official.website.model.OfficialWebsiteFirstScreen;
import space.zero.business.module.official.website.service.OfficialWebsiteFirstScreenService;
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
@RequestMapping("/official/website/first/screen")
public class OfficialWebsiteFirstScreenController {
    @Resource
    private OfficialWebsiteFirstScreenService officialWebsiteFirstScreenService;
    @Value("${website.global.host}")
    private String host;

    @PostMapping
    public Result add(@RequestBody OfficialWebsiteFirstScreen officialWebsiteFirstScreen) {
        officialWebsiteFirstScreen.setPic(officialWebsiteFirstScreen.getPic().replace(host, ""));
        OfficialWebsiteFirstScreen tmp = officialWebsiteFirstScreenService.save(officialWebsiteFirstScreen);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        officialWebsiteFirstScreenService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody OfficialWebsiteFirstScreen officialWebsiteFirstScreen) {
        officialWebsiteFirstScreen.setPic(officialWebsiteFirstScreen.getPic().replace(host, ""));
        OfficialWebsiteFirstScreen tmp = officialWebsiteFirstScreenService.update(officialWebsiteFirstScreen);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        OfficialWebsiteFirstScreen officialWebsiteFirstScreen = officialWebsiteFirstScreenService.findById(id);
        return ResultGenerator.genSuccessResult(officialWebsiteFirstScreen);
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
        }
        List<OfficialWebsiteFirstScreen> list = officialWebsiteFirstScreenService.findBy(condRequest.getCond());
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.getList().forEach(item -> {
            OfficialWebsiteFirstScreen firstScreen = (OfficialWebsiteFirstScreen)item;
            firstScreen.setPic(host + firstScreen.getPic());
        });
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping("/checkout/{id}")
    public Result checkoutStatus(@PathVariable String id){
        OfficialWebsiteFirstScreen firstScreen = officialWebsiteFirstScreenService.findById(id);
        if (ENABLE_FLAG_TRUE.equals(firstScreen.getIsEnable())){
            firstScreen.setIsEnable(ENABLE_FLAG_FALSE);
        }else if (ENABLE_FLAG_FALSE.equals(firstScreen.getIsEnable())){
            firstScreen.setIsEnable(ENABLE_FLAG_TRUE);
        }
        officialWebsiteFirstScreenService.update(firstScreen);
        return ResultGenerator.genSuccessResult(firstScreen);
    }

    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file){
        FileUploadUtils fileUploadUtils = new FileUploadUtils();
        String filePath = null;
        try {
            filePath = host + fileUploadUtils.uploadFile(file, FileUploadEnum.FIRSTSCREEN);
        } catch (IOException e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult("fail");
        }
        return ResultGenerator.genSuccessResult(filePath, "success");
    }
}
