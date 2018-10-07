package space.zero.business.module.official.website.service.impl;

import space.zero.business.module.official.website.base.WebsiteDeleteFlagService;
import space.zero.business.module.official.website.dao.OfficialWebsiteCustomerCaseMapper;
import space.zero.business.module.official.website.model.OfficialWebsiteCustomerCase;
import space.zero.business.module.official.website.service.OfficialWebsiteCustomerCaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by PG_shen on 2018/09/26.
 */
@Service
@Transactional
public class OfficialWebsiteCustomerCaseServiceImpl extends WebsiteDeleteFlagService<OfficialWebsiteCustomerCase> implements OfficialWebsiteCustomerCaseService {
    @Resource
    private OfficialWebsiteCustomerCaseMapper officialWebsiteCustomerCaseMapper;

}
