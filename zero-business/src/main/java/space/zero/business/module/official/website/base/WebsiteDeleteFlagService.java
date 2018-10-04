package space.zero.business.module.official.website.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import space.zero.business.module.sys.model.SysUserDetails;
import space.zero.common.keyGenerator.KeyGenerator;
import space.zero.core.service.AbstractDeleteFlagService;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by IntelliJ IDEA
 * User: pipix
 * Date: 10/4/18
 * TIME: 4:19 PM
 */
public abstract class WebsiteDeleteFlagService<T extends WebsiteEntity> extends AbstractDeleteFlagService<T> {

    @Autowired
    private KeyGenerator<String> keyGenerator;

    @Override
    public boolean preInsert(T data) {
        data.setId(keyGenerator.getNext());
        SysUserDetails sysUserDetails = (SysUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        data.setUpdateUser(sysUserDetails.getUser().getName());
        data.setCreatedTime(new Timestamp(new Date().getTime()));
        return super.preInsert(data);
    }
}
