package space.zero.business.module.official.website.service.impl;

import space.zero.business.module.official.website.base.WebsiteDeleteFlagService;
import space.zero.business.module.official.website.model.OfficialWebsiteCarousel;
import space.zero.business.module.official.website.service.OfficialWebsiteCarouselService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 * Created by PG_shen on 2018/09/26.
 */
@Service
@Transactional
public class OfficialWebsiteCarouselServiceImpl extends WebsiteDeleteFlagService<OfficialWebsiteCarousel> implements OfficialWebsiteCarouselService {

}
