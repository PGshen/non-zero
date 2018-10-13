package space.zero.business.module.official.website.web.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.zero.business.module.official.website.model.OfficialWebsiteBaseInfo;
import space.zero.business.module.official.website.model.OfficialWebsiteCarousel;
import space.zero.business.module.official.website.param.request.CondRequest;
import space.zero.business.module.official.website.service.*;
import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return ResultGenerator.genSuccessResult(officialWebsiteBaseInfo);
    }

    /**
     * 获取轮播图列表
     * @return
     */
    @GetMapping("/carousel")
    public Result carousel(){
        Map map = new HashMap<String, Object>();
        map.put("isEnable", "1");
        List<OfficialWebsiteCarousel> carouselList = carouselService.findBy(map);
        carouselList.forEach(item -> {
            OfficialWebsiteCarousel carousel = (OfficialWebsiteCarousel)item;
            carousel.setPic(host + carousel.getPic());
        });
        return ResultGenerator.genSuccessResult(carouselList);
    }


}
