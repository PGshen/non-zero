package space.zero.business.module.official.website.service.impl;

import space.zero.business.module.official.website.base.WebsiteDeleteFlagService;
import space.zero.business.module.official.website.dao.OfficialWebsiteSolutionMapper;
import space.zero.business.module.official.website.model.OfficialWebsiteSolution;
import space.zero.business.module.official.website.service.OfficialWebsiteSolutionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by PG_shen on 2018/09/26.
 */
@Service
@Transactional
public class OfficialWebsiteSolutionServiceImpl extends WebsiteDeleteFlagService<OfficialWebsiteSolution> implements OfficialWebsiteSolutionService {
    @Resource
    private OfficialWebsiteSolutionMapper officialWebsiteSolutionMapper;

}
