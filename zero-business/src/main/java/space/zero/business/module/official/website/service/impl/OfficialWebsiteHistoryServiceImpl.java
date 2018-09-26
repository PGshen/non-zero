package space.zero.business.module.official.website.service.impl;

import space.zero.business.module.official.website.dao.OfficialWebsiteHistoryMapper;
import space.zero.business.module.official.website.model.OfficialWebsiteHistory;
import space.zero.business.module.official.website.service.OfficialWebsiteHistoryService;
import space.zero.core.service.AbstractDeleteFlagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by PG_shen on 2018/09/26.
 */
@Service
@Transactional
public class OfficialWebsiteHistoryServiceImpl extends AbstractDeleteFlagService<OfficialWebsiteHistory> implements OfficialWebsiteHistoryService {
    @Resource
    private OfficialWebsiteHistoryMapper officialWebsiteHistoryMapper;

}
