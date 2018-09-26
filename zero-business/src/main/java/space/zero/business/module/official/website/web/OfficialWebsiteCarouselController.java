package space.zero.business.module.official.website.web;

import space.zero.core.result.Result;
import space.zero.core.result.ResultGenerator;
import space.zero.business.module.official.website.model.OfficialWebsiteCarousel;
import space.zero.business.module.official.website.service.OfficialWebsiteCarouselService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by PG_shen on 2018/09/26.
*/
@RestController
@RequestMapping("/official/website/carousel")
public class OfficialWebsiteCarouselController {
    @Resource
    private OfficialWebsiteCarouselService officialWebsiteCarouselService;

    @PostMapping
    public Result add(@RequestBody OfficialWebsiteCarousel officialWebsiteCarousel) {
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
        OfficialWebsiteCarousel tmp = officialWebsiteCarouselService.update(officialWebsiteCarousel);
        return ResultGenerator.genSuccessResult(tmp);
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable String id) {
        OfficialWebsiteCarousel officialWebsiteCarousel = officialWebsiteCarouselService.findById(id);
        return ResultGenerator.genSuccessResult(officialWebsiteCarousel);
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<OfficialWebsiteCarousel> list = officialWebsiteCarouselService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
