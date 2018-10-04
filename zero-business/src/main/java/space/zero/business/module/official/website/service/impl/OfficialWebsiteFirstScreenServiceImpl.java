package space.zero.business.module.official.website.service.impl;

import space.zero.business.module.official.website.base.WebsiteDeleteFlagService;
import space.zero.business.module.official.website.dao.OfficialWebsiteFirstScreenMapper;
import space.zero.business.module.official.website.model.OfficialWebsiteFirstScreen;
import space.zero.business.module.official.website.service.OfficialWebsiteFirstScreenService;
import space.zero.core.service.AbstractDeleteFlagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by PG_shen on 2018/09/26.
 */
@Service
@Transactional
public class OfficialWebsiteFirstScreenServiceImpl extends WebsiteDeleteFlagService<OfficialWebsiteFirstScreen> implements OfficialWebsiteFirstScreenService {
    @Resource
    private OfficialWebsiteFirstScreenMapper officialWebsiteFirstScreenMapper;

}
