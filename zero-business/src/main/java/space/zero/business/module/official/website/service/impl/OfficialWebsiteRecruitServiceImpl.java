package space.zero.business.module.official.website.service.impl;

import space.zero.business.module.official.website.dao.OfficialWebsiteRecruitMapper;
import space.zero.business.module.official.website.model.OfficialWebsiteRecruit;
import space.zero.business.module.official.website.service.OfficialWebsiteRecruitService;
import space.zero.core.service.AbstractDeleteFlagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by PG_shen on 2018/09/26.
 */
@Service
@Transactional
public class OfficialWebsiteRecruitServiceImpl extends AbstractDeleteFlagService<OfficialWebsiteRecruit> implements OfficialWebsiteRecruitService {
    @Resource
    private OfficialWebsiteRecruitMapper officialWebsiteRecruitMapper;

}
