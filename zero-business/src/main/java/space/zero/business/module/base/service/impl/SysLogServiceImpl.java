package space.zero.business.module.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import space.zero.business.module.base.dao.SysLogMapper;
import space.zero.business.module.base.model.SysLog;
import space.zero.business.module.base.service.SysLogService;
import space.zero.common.keyGenerator.KeyGenerator;
import space.zero.common.utils.StringUtils;
import space.zero.core.service.AbstractDeleteFlagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;


/**
 * Created by PG_shen on 2018/08/19.
 */
@Service
@Transactional
public class SysLogServiceImpl extends AbstractDeleteFlagService<SysLog> implements SysLogService {
    @Resource
    private SysLogMapper sysLogMapper;

    @Autowired
    private KeyGenerator<String> keyGenerator;

    @Override
    public boolean preInsert(SysLog data) {
        if (StringUtils.isBlank(data.getId())) {
            data.setId(keyGenerator.getNext());
        }
        data.setCreatedTime(new Timestamp(new Date().getTime()));
        return super.preInsert(data);
    }


}
