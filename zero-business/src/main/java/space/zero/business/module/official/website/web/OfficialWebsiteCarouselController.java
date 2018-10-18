package space.zero.business.module.official.website.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;
import space.zero.business.module.official.website.param.request.CondRequest;
import space.zero.common.utils.FileUploadEnum;
import space.zero.common.utils.FileUploadUtils;
import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;
import space.zero.business.module.official.website.model.OfficialWebsiteCarousel;
import space.zero.business.module.official.website.service.OfficialWebsiteCarouselService;
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
@RequestMapping("/official/website/carousel")
public class OfficialWebsiteCarouselController {
    @Resource
    private OfficialWebsiteCarouselService officialWebsiteCarouselService;
    @Value("${website.global.host}")
    private String host;

    @PostMapping
    public Result add(@RequestBody OfficialWebsiteCarousel officialWebsiteCarousel) {
        officialWebsiteCarousel.setPic(officialWebsiteCarousel.getPic().replace(host,""));
        OfficialWebsiteCarousel tmp = officialWebsiteCarouselService.save(officialWebsiteCarousel);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        officialWebsiteCarouselService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody OfficialWebsiteCarousel officialWebsiteCarousel) {
        officialWebsiteCarousel.setPic(officialWebsiteCarousel.getPic().replace(host,""));
        OfficialWebsiteCarousel tmp = officialWebsiteCarouselService.update(officialWebsiteCarousel);
//        tmp.setPic(host + tmp.getPic());
        return ResultGenerator.genSuccessResult(tmp);
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        OfficialWebsiteCarousel officialWebsiteCarousel = officialWebsiteCarouselService.findById(id);
        return ResultGenerator.genSuccessResult(officialWebsiteCarousel);
    }

    @PostMapping("/checkout/{id}")
    public Result checkoutStatus(@PathVariable String id){
        OfficialWebsiteCarousel carousel = officialWebsiteCarouselService.findById(id);
        if (ENABLE_FLAG_TRUE.equals(carousel.getIsEnable())){
            carousel.setIsEnable(ENABLE_FLAG_FALSE);
        }else if (ENABLE_FLAG_FALSE.equals(carousel.getIsEnable())){
            carousel.setIsEnable(ENABLE_FLAG_TRUE);
        }
        officialWebsiteCarouselService.update(carousel);
        return ResultGenerator.genSuccessResult(carousel);
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
            if ("heading".equals(key) && condRequest.getCond().get(key).equals("")){
                iterator.remove();
            }
        }
        List<OfficialWebsiteCarousel> list = officialWebsiteCarouselService.findBy(condRequest.getCond());
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.setOrderBy(condRequest.getOrder());
        pageInfo.getList().forEach(item ->{
            OfficialWebsiteCarousel carousel = (OfficialWebsiteCarousel)item;
//            carousel.setDescription(carousel.getDescription().substring(0, carousel.getDescription().length() > 45 ? 45 : carousel.getDescription().length()) + "...");
            carousel.setPic(host+carousel.getPic());
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
