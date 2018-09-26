package space.zero.business.module.official.website.service.impl;

import space.zero.business.module.official.website.dao.OfficialWebsiteCarouselMapper;
import space.zero.business.module.official.website.model.OfficialWebsiteCarousel;
import space.zero.business.module.official.website.service.OfficialWebsiteCarouselService;
import space.zero.core.service.AbstractDeleteFlagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by PG_shen on 2018/09/26.
 */
@Service
@Transactional
public class OfficialWebsiteCarouselServiceImpl extends AbstractDeleteFlagService<OfficialWebsiteCarousel> implements OfficialWebsiteCarouselService {
    @Resource
    private OfficialWebsiteCarouselMapper officialWebsiteCarouselMapper;

}
