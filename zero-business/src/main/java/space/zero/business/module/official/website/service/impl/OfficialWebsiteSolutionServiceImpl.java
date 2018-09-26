package space.zero.business.module.official.website.service.impl;

import space.zero.business.module.official.website.dao.OfficialWebsiteSolutionMapper;
import space.zero.business.module.official.website.model.OfficialWebsiteSolution;
import space.zero.business.module.official.website.service.OfficialWebsiteSolutionService;
import space.zero.core.service.AbstractDeleteFlagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by PG_shen on 2018/09/26.
 */
@Service
@Transactional
public class OfficialWebsiteSolutionServiceImpl extends AbstractDeleteFlagService<OfficialWebsiteSolution> implements OfficialWebsiteSolutionService {
    @Resource
    private OfficialWebsiteSolutionMapper officialWebsiteSolutionMapper;

}
