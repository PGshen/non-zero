package space.zero.business.module.official.website.service.impl;

import space.zero.business.module.official.website.dao.OfficialWebsiteDigitizationMapper;
import space.zero.business.module.official.website.model.OfficialWebsiteDigitization;
import space.zero.business.module.official.website.service.OfficialWebsiteDigitizationService;
import space.zero.core.service.AbstractDeleteFlagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by PG_shen on 2018/09/26.
 */
@Service
@Transactional
public class OfficialWebsiteDigitizationServiceImpl extends AbstractDeleteFlagService<OfficialWebsiteDigitization> implements OfficialWebsiteDigitizationService {
    @Resource
    private OfficialWebsiteDigitizationMapper officialWebsiteDigitizationMapper;

}
