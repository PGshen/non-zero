package space.zero.business.module.official.website.service.impl;

import space.zero.business.module.official.website.base.WebsiteDeleteFlagService;
import space.zero.business.module.official.website.dao.OfficialWebsiteClassMateMapper;
import space.zero.business.module.official.website.model.OfficialWebsiteClassMate;
import space.zero.business.module.official.website.param.response.ClazzListResponse;
import space.zero.business.module.official.website.service.OfficialWebsiteClassMateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by PG_shen on 2018/10/04.
 */
@Service
@Transactional
public class OfficialWebsiteClassMateServiceImpl extends WebsiteDeleteFlagService<OfficialWebsiteClassMate> implements OfficialWebsiteClassMateService {
    @Resource
    private OfficialWebsiteClassMateMapper officialWebsiteClassMateMapper;

    @Override
    public List<ClazzListResponse> findClazz(String clazzName) {
        return officialWebsiteClassMateMapper.findClazz(clazzName);
    }
}
