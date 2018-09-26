package space.zero.business.module.official.website.service.impl;

import space.zero.business.module.official.website.dao.OfficialWebsiteClassMateMapper;
import space.zero.business.module.official.website.model.OfficialWebsiteClassMate;
import space.zero.business.module.official.website.service.OfficialWebsiteClassMateService;
import space.zero.core.service.AbstractDeleteFlagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by PG_shen on 2018/09/26.
 */
@Service
@Transactional
public class OfficialWebsiteClassMateServiceImpl extends AbstractDeleteFlagService<OfficialWebsiteClassMate> implements OfficialWebsiteClassMateService {
    @Resource
    private OfficialWebsiteClassMateMapper officialWebsiteClassMateMapper;

}
