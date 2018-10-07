package space.zero.business.module.official.website.service.impl;

import space.zero.business.module.official.website.base.WebsiteDeleteFlagService;
import space.zero.business.module.official.website.dao.OfficialWebsiteNewsMapper;
import space.zero.business.module.official.website.model.OfficialWebsiteNews;
import space.zero.business.module.official.website.service.OfficialWebsiteNewsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by PG_shen on 2018/09/26.
 */
@Service
@Transactional
public class OfficialWebsiteNewsServiceImpl extends WebsiteDeleteFlagService<OfficialWebsiteNews> implements OfficialWebsiteNewsService {
    @Resource
    private OfficialWebsiteNewsMapper officialWebsiteNewsMapper;

}
