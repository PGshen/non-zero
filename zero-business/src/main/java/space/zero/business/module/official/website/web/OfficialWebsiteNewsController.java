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
import space.zero.business.module.official.website.model.OfficialWebsiteNews;
import space.zero.business.module.official.website.service.OfficialWebsiteNewsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static space.zero.core.constant.Constant.*;

/**
* Created by PG_shen on 2018/09/26.
*/
@RestController
@RequestMapping("/official/website/news")
public class OfficialWebsiteNewsController {
    @Resource
    private OfficialWebsiteNewsService officialWebsiteNewsService;
    @Resource
    private OfficialWebsiteClassMateService classMateService;
    @Value("${website.global.host}")
    private String host;

    @PostMapping
    public Result add(@RequestBody OfficialWebsiteNews officialWebsiteNews) {
        officialWebsiteNews.setTitlePic(officialWebsiteNews.getTitlePic().replace(host, ""));
        OfficialWebsiteNews tmp = officialWebsiteNewsService.save(officialWebsiteNews);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable String id) {
        officialWebsiteNewsService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PutMapping
    public Result update(@RequestBody OfficialWebsiteNews officialWebsiteNews) {
        officialWebsiteNews.setTitlePic(officialWebsiteNews.getTitlePic().replace(host, ""));
        OfficialWebsiteNews tmp = officialWebsiteNewsService.update(officialWebsiteNews);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        OfficialWebsiteNews officialWebsiteNews = officialWebsiteNewsService.findById(id);
        officialWebsiteNews.setTitlePic(host+officialWebsiteNews.getTitlePic());
        return ResultGenerator.genSuccessResult(officialWebsiteNews);
    }

    @PostMapping("/list")
    public Result list(@RequestBody CondRequest condRequest) {
        PageHelper.startPage(condRequest.getPage(), condRequest.getSize(), StringUtils.HumpToUnderline(condRequest.getOrder()) + " desc");
        Iterator<String> iterator = condRequest.getCond().keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            if ("status".equals(key) && (condRequest.getCond().get(key).equals("-1") || condRequest.getCond().equals(""))){
                iterator.remove();
            }
            if ("title".equals(key) && condRequest.getCond().get(key).equals("")){
                iterator.remove();
            }
        }
        List<OfficialWebsiteNews> list = officialWebsiteNewsService.findBy(condRequest.getCond());
//        获取所有的新闻类别,并转成map
        List<ClazzListResponse> newsClazz = classMateService.findClazz("NEWS");
        Map<String, String> newsClazzMap = newsClazz.stream().collect(Collectors.toMap(ClazzListResponse::getId, ClazzListResponse::getClazzValue,(k1, k2)->k1));
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.getList().forEach(item ->{
            OfficialWebsiteNews news = (OfficialWebsiteNews) item;
            news.setTitlePic(host+news.getTitlePic());
            news.setNewsClass(newsClazzMap.get(news.getNewsClass()));
        });
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 切换文章的状态 已发布<->草稿
     * @param id
     * @return
     */
    @PostMapping("/checkout/{id}")
    public Result checkoutStatus(@PathVariable String id){
        OfficialWebsiteNews news = officialWebsiteNewsService.findById(id);
        if (WEBSITE_NEWS_STATUS_PUBLISHED.equals(news.getStatus())){
            news.setStatus(WEBSITE_NEWS_STATUS_DRAFT);
        }else if (WEBSITE_NEWS_STATUS_DRAFT.equals(news.getStatus())){
            news.setStatus(WEBSITE_NEWS_STATUS_PUBLISHED);
        }
        officialWebsiteNewsService.update(news);
        return ResultGenerator.genSuccessResult(news);
    }

    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file){
        FileUploadUtils fileUploadUtils = new FileUploadUtils();
        String filePath = null;
        try {
            filePath = host + fileUploadUtils.uploadFile(file, FileUploadEnum.NEWS);
        } catch (IOException e) {
            e.printStackTrace();
            return ResultGenerator.genFailResult("fail");
        }
        return ResultGenerator.genSuccessResult(filePath, "success");
    }
}
