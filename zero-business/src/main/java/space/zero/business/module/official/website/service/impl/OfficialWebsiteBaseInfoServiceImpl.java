package space.zero.business.module.official.website.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import space.zero.business.module.official.website.base.WebsiteDeleteFlagService;
import space.zero.business.module.official.website.dao.OfficialWebsiteBaseInfoMapper;
import space.zero.business.module.official.website.model.OfficialWebsiteBaseInfo;
import space.zero.business.module.official.website.service.OfficialWebsiteBaseInfoService;
import space.zero.common.keyGenerator.KeyGenerator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;


/**
 * Created by PG_shen on 2018/09/26.
 */
@Service
@Transactional
public class OfficialWebsiteBaseInfoServiceImpl extends WebsiteDeleteFlagService<OfficialWebsiteBaseInfo> implements OfficialWebsiteBaseInfoService {
    @Resource
    private OfficialWebsiteBaseInfoMapper officialWebsiteBaseInfoMapper;

    @Autowired
    private KeyGenerator<String> keyGenerator;


    @Override
    public OfficialWebsiteBaseInfo fetchInfo() {
        return officialWebsiteBaseInfoMapper.fetchInfo();
    }

    @Override
    public OfficialWebsiteBaseInfo updateInfo(OfficialWebsiteBaseInfo baseInfo) {
        officialWebsiteBaseInfoMapper.setAllDisable();
        return super.save(baseInfo);
    }

}
