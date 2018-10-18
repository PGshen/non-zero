package space.zero.business.module.official.website.service.impl;

import space.zero.business.module.official.website.base.WebsiteDeleteFlagService;
import space.zero.business.module.official.website.dao.OfficialWebsiteContactUsMapper;
import space.zero.business.module.official.website.model.OfficialWebsiteContactUs;
import space.zero.business.module.official.website.service.OfficialWebsiteContactUsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by PG_shen on 2018/09/26.
 */
@Service
@Transactional
public class OfficialWebsiteContactUsServiceImpl extends WebsiteDeleteFlagService<OfficialWebsiteContactUs> implements OfficialWebsiteContactUsService {
    @Resource
    private OfficialWebsiteContactUsMapper officialWebsiteContactUsMapper;

}
