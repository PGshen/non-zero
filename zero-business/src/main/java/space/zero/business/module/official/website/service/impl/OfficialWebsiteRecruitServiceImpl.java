package space.zero.business.module.official.website.service.impl;

import space.zero.business.module.official.website.base.WebsiteDeleteFlagService;
import space.zero.business.module.official.website.dao.OfficialWebsiteRecruitMapper;
import space.zero.business.module.official.website.model.OfficialWebsiteRecruit;
import space.zero.business.module.official.website.service.OfficialWebsiteRecruitService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by PG_shen on 2018/09/26.
 */
@Service
@Transactional
public class OfficialWebsiteRecruitServiceImpl extends WebsiteDeleteFlagService<OfficialWebsiteRecruit> implements OfficialWebsiteRecruitService {
    @Resource
    private OfficialWebsiteRecruitMapper officialWebsiteRecruitMapper;

}
