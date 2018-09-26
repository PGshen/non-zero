package space.zero.business.module.official.website.service.impl;

import space.zero.business.module.official.website.dao.OfficialWebsiteAboutUsMapper;
import space.zero.business.module.official.website.model.OfficialWebsiteAboutUs;
import space.zero.business.module.official.website.service.OfficialWebsiteAboutUsService;
import space.zero.core.service.AbstractDeleteFlagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by PG_shen on 2018/09/26.
 */
@Service
@Transactional
public class OfficialWebsiteAboutUsServiceImpl extends AbstractDeleteFlagService<OfficialWebsiteAboutUs> implements OfficialWebsiteAboutUsService {
    @Resource
    private OfficialWebsiteAboutUsMapper officialWebsiteAboutUsMapper;

}
