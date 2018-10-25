package space.zero.business.module.official.website.web.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import space.zero.business.module.official.website.model.*;
import space.zero.business.module.official.website.param.request.CondRequest;
import space.zero.business.module.official.website.param.response.ClazzListResponse;
import space.zero.business.module.official.website.param.response.NewsDetailResponse;
import space.zero.business.module.official.website.service.*;
import space.zero.core.constant.Constant;
import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA
 * 无需认证即可访问的website接口
 * User: pipix
 * Date: 10/12/18
 * TIME: 10:53 PM
 */
@RestController
@RequestMapping("/api/official/website")
public class OfficialWebsiteController {
    private final static Logger logger = LoggerFactory.getLogger(OfficialWebsiteController.class);
    @Resource
    private OfficialWebsiteBaseInfoService baseInfoService;
    @Resource
    private OfficialWebsiteContactUsService contactUsService;
    @Resource
    private OfficialWebsiteSolutionService solutionService;
    @Resource
    private OfficialWebsiteProductService productService;
    @Resource
    private OfficialWebsiteCustomerCaseService customerCaseService;
    @Resource
    private OfficialWebsiteNewsService newsService;
    @Resource
    private OfficialWebsiteAboutUsService aboutUsService;
    @Resource
    private OfficialWebsiteCarouselService carouselService;
    @Resource
    private OfficialWebsiteFirstScreenService firstScreenService;
    @Resource
    private OfficialWebsiteClassMateService classMateService;

    @Value("${website.global.host}")
    private String host;

    /**
     * 获取网站基本信息
     * @return
     */
    @GetMapping("/base/info")
    public Result baseInfo() {
        OfficialWebsiteBaseInfo officialWebsiteBaseInfo = baseInfoService.fetchInfo();
        officialWebsiteBaseInfo.setLogoUrl(host+ officialWebsiteBaseInfo.getLogoUrl());
        officialWebsiteBaseInfo.setQrCodeUrl(host + officialWebsiteBaseInfo.getQrCodeUrl());
        logger.info("get website base info ", officialWebsiteBaseInfo);
        return ResultGenerator.genSuccessResult(officialWebsiteBaseInfo);
    }

    /**
     * 获取轮播图列表
     * @return
     */
    @GetMapping("/carousel")
    public Result carousel(){
        Map map = new HashMap<String, Object>();
        map.put("isEnable", Constant.ENABLE_FLAG_TRUE);
        List<OfficialWebsiteCarousel> carouselList = carouselService.findBy(map);
        carouselList.forEach(item -> {
            OfficialWebsiteCarousel carousel = (OfficialWebsiteCarousel)item;
            carousel.setPic(host + carousel.getPic());
        });
        logger.info("get website carousel list ", carouselList);
        return ResultGenerator.genSuccessResult(carouselList);
    }

    @PostMapping("/first/screen")
    public Result firstScreen(@RequestBody CondRequest condRequest){
        List<OfficialWebsiteClassMate> classMateList = classMateService.findBy(condRequest.getCond());
        if (classMateList.size() < 1) {
            return ResultGenerator.genFailResult("获取FIRST SCREEN类别失败");
        }else {
            OfficialWebsiteFirstScreen firstScreen = firstScreenService.fetchFirstScreen(classMateList.get(0).getId());
            if (firstScreen == null){
                return ResultGenerator.genFailResult("获取FIRST SCREEN失败");
            } else {
                firstScreen.setPic(host + firstScreen.getPic());
                logger.info("get website first screen - " + condRequest.getCond().get("clazzName"), firstScreen);
                return ResultGenerator.genSuccessResult(firstScreen);
            }
        }
    }

    @GetMapping("/contact")
    public Result contact(){
        Map map = new HashMap<String, Object>();
        map.put("isEnable", Constant.ENABLE_FLAG_TRUE);
        List<OfficialWebsiteContactUs> contactUsList = contactUsService.findBy(map);
        contactUsList.forEach(item -> {
            OfficialWebsiteContactUs contactUs = (OfficialWebsiteContactUs)item;
            contactUs.setPic(host + contactUs.getPic());
        });
        logger.info("get website contact info ", contactUsList);
        return ResultGenerator.genSuccessResult(contactUsList);
    }

    @PostMapping("/about/us")
    public Result aboutUs(@RequestBody CondRequest condRequest){
        List<OfficialWebsiteClassMate> classMateList = classMateService.findBy(condRequest.getCond());
        if (classMateList.size() < 1){
            return ResultGenerator.genFailResult("获取ABOUT US类别失败");
        } else {
            String clazzId = classMateList.get(0).getId();
            Map map = condRequest.getCond();
            map.remove("clazzName");
            map.remove("clazzValue");
            map.put("aboutUsClass", clazzId);
            condRequest.setCond(map);
            PageHelper.startPage(condRequest.getPage(), condRequest.getSize(), condRequest.getOrder());
            List<OfficialWebsiteAboutUs> aboutUsList = aboutUsService.findBy(map);
            if (aboutUsList.size() < 1){
                return ResultGenerator.genFailResult("获取关于我们失败");
            }else {
                PageInfo pageInfo = new PageInfo(aboutUsList);
                logger.info("get website about us info list ", aboutUsList);
                return ResultGenerator.genSuccessResult(pageInfo.getList().get(0));
            }
        }
    }

    @PostMapping("/news")
    public Result news(@RequestBody CondRequest condRequest) {
        Map map = condRequest.getCond();
        List<OfficialWebsiteClassMate> classMateList = classMateService.findBy(condRequest.getCond());
        if (classMateList.size() < 1){
            return ResultGenerator.genFailResult("获取NEWS类别失败");
        } else {
            String clazzId = classMateList.get(0).getId();
            map.remove("clazzName");
            map.remove("clazzValue");
            map.put("newsClass", clazzId);
            map.put("status", Constant.WEBSITE_NEWS_STATUS_PUBLISHED);
            condRequest.setCond(map);
            PageHelper.startPage(condRequest.getPage(), condRequest.getSize(), condRequest.getOrder());
            List<OfficialWebsiteNews> list = newsService.findBy(condRequest.getCond());
            if (list.size() < 1) {
                return ResultGenerator.genFailResult("获取新闻失败");
            }
            PageInfo pageInfo = new PageInfo(list);
            pageInfo.getList().forEach(item -> {
                OfficialWebsiteNews news = (OfficialWebsiteNews) item;
                news.setTitlePic(host + news.getTitlePic());
            });
            logger.info("get website news list info ", list);
            return ResultGenerator.genSuccessResult(pageInfo);
        }
    }

    @GetMapping("/news/{id}")
    public Result newsDetail(@PathVariable String id) {
        OfficialWebsiteNews officialWebsiteNews = newsService.findById(id);
        officialWebsiteNews.setTitlePic(host+officialWebsiteNews.getTitlePic());
        String newsClazz = officialWebsiteNews.getNewsClass();
        OfficialWebsiteNews nextNews = newsService.getNextNews(id, newsClazz);
        OfficialWebsiteNews previousNews = newsService.getPreviousNews(id, newsClazz);
        NewsDetailResponse response = new NewsDetailResponse();
        response.setNews(officialWebsiteNews);
        response.setNext(nextNews);
        response.setPrevious(previousNews);
        logger.info("get website news detail info - " + id);
        return ResultGenerator.genSuccessResult(response);
    }

    @PostMapping("/solution")
    public Result solutions(@RequestBody CondRequest condRequest) {
        Map map = condRequest.getCond();
        map.put("isEnable", Constant.ENABLE_FLAG_TRUE);
        condRequest.setCond(map);
        PageHelper.startPage(condRequest.getPage(), condRequest.getSize(), condRequest.getOrder());
        List<OfficialWebsiteSolution> list = solutionService.findBy(condRequest.getCond());
        if (list.size() < 1) {
            return ResultGenerator.genFailResult("获取方案失败");
        }
        // 获取SOLUTION类别
        List<ClazzListResponse> solutionClazz = classMateService.findClazz("SOLUTION");
        Map<String, String> solutionClazzMap = solutionClazz.stream().collect(Collectors.toMap(ClazzListResponse::getId, ClazzListResponse::getClazzValue,(k1, k2)->k1));
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.getList().forEach(item -> {
            OfficialWebsiteSolution solution = (OfficialWebsiteSolution) item;
            solution.setSolutionPic(host + solution.getSolutionPic());
            solution.setSolutionClass(solutionClazzMap.get(solution.getSolutionClass()));
        });
        logger.info("get website solution list");
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/solution/{id}")
    public Result solutionDetail(@PathVariable String id) {
        OfficialWebsiteSolution solution = solutionService.findById(id);
        // 获取SOLUTION类别
        List<ClazzListResponse> solutionClazz = classMateService.findClazz("SOLUTION");
        Map<String, String> solutionClazzMap = solutionClazz.stream().collect(Collectors.toMap(ClazzListResponse::getId, ClazzListResponse::getClazzValue,(k1, k2)->k1));
        solution.setSolutionPic(host + solution.getSolutionPic());
        solution.setSolutionClass(solutionClazzMap.get(solution.getSolutionClass()));
        logger.info("get website solution detail info - " + id);
        return ResultGenerator.genSuccessResult(solution);
    }

    @PostMapping("/product")
    public Result products(@RequestBody CondRequest condRequest) {
        Map map = condRequest.getCond();
        map.put("isEnable", Constant.ENABLE_FLAG_TRUE);
        condRequest.setCond(map);
        PageHelper.startPage(condRequest.getPage(), condRequest.getSize(), condRequest.getOrder());
        List<OfficialWebsiteProduct> list = productService.findBy(condRequest.getCond());
        if (list.size() < 1) {
            return ResultGenerator.genFailResult("获取产品失败");
        }
        // 获取SOLUTION类别
        List<ClazzListResponse> productClazz = classMateService.findClazz("PRODUCT");
        Map<String, String> productClazzMap = productClazz.stream().collect(Collectors.toMap(ClazzListResponse::getId, ClazzListResponse::getClazzValue,(k1, k2)->k1));
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.getList().forEach(item -> {
            OfficialWebsiteProduct product = (OfficialWebsiteProduct) item;
            product.setProductPic(host + product.getProductPic());
            product.setProductClass(productClazzMap.get(product.getProductClass()));
        });
        logger.info("get website product list");
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/product/{id}")
    public Result productDetail(@PathVariable String id) {
        OfficialWebsiteProduct officialWebsiteProduct = productService.findById(id);
        // 获取SOLUTION类别
        List<ClazzListResponse> productClazz = classMateService.findClazz("PRODUCT");
        Map<String, String> productClazzMap = productClazz.stream().collect(Collectors.toMap(ClazzListResponse::getId, ClazzListResponse::getClazzValue,(k1, k2)->k1));
        officialWebsiteProduct.setProductPic(host + officialWebsiteProduct.getProductPic());
        officialWebsiteProduct.setProductClass(productClazzMap.get(officialWebsiteProduct.getProductClass()));
        logger.info("get website product detail info - " + id);
        return ResultGenerator.genSuccessResult(officialWebsiteProduct);
    }

    @PostMapping("/case")
    public Result customerCase(@RequestBody CondRequest condRequest) {
        Map map = condRequest.getCond();
        map.put("isEnable", Constant.ENABLE_FLAG_TRUE);
        condRequest.setCond(map);
        PageHelper.startPage(condRequest.getPage(), condRequest.getSize(), condRequest.getOrder());
        List<OfficialWebsiteCustomerCase> list = customerCaseService.findBy(condRequest.getCond());
        if (list.size() < 1) {
            return ResultGenerator.genFailResult("获取案例失败");
        }
        // 获取SOLUTION类别
        List<ClazzListResponse> caseClazz = classMateService.findClazz("CASE");
        Map<String, String> caseClazzMap = caseClazz.stream().collect(Collectors.toMap(ClazzListResponse::getId, ClazzListResponse::getClazzValue,(k1, k2)->k1));
        PageInfo pageInfo = new PageInfo(list);
        pageInfo.getList().forEach(item -> {
            OfficialWebsiteCustomerCase customerCase = (OfficialWebsiteCustomerCase) item;
            customerCase.setCasePic(host + customerCase.getCasePic());
            customerCase.setCaseClass(caseClazzMap.get(customerCase.getCaseClass()));
        });
        logger.info("get website customer case list");
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @GetMapping("/case/{id}")
    public Result customerCaseDetail(@PathVariable String id) {
        OfficialWebsiteCustomerCase officialWebsiteCustomerCase = customerCaseService.findById(id);
        // 获取SOLUTION类别
        List<ClazzListResponse> caseClazz = classMateService.findClazz("CASE");
        Map<String, String> caseClazzMap = caseClazz.stream().collect(Collectors.toMap(ClazzListResponse::getId, ClazzListResponse::getClazzValue,(k1, k2)->k1));
        officialWebsiteCustomerCase.setCasePic(host + officialWebsiteCustomerCase.getCasePic());
        officialWebsiteCustomerCase.setCaseClass(caseClazzMap.get(officialWebsiteCustomerCase.getCaseClass()));
        logger.info("get website customer case detail info - " + id);
        return ResultGenerator.genSuccessResult(officialWebsiteCustomerCase);
    }
}
