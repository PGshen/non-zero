package space.zero.business.module.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import space.zero.business.module.sys.dao.SysRoleMenuMapper;
import space.zero.business.module.sys.model.SysRoleMenu;
import space.zero.business.module.sys.service.SysRoleMenuService;
import space.zero.common.keyGenerator.KeyGenerator;
import space.zero.common.utils.StringUtils;
import space.zero.core.service.AbstractDeleteFlagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * Created by PG_shen on 2018/03/08.
 */
@Service
@Transactional
public class SysRoleMenuServiceImpl extends AbstractDeleteFlagService<SysRoleMenu> implements SysRoleMenuService {
    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;
    @Autowired
    private KeyGenerator<String> keyGenerator;

    public List<SysRoleMenu> findAllByRoleId(String roleId){
        if (!StringUtils.isBlank(roleId) && !StringUtils.isEmpty(roleId)) {
//            return sysRoleMenuMapper.findAllByRoleId(roleId);
            return super.findBy("roleId",roleId);
        }

        return null;
    }

    public List<String> findAuthList(String roleId){
        return sysRoleMenuMapper.findAuthByRoleId(roleId);
    }

    public List<String> findMenuList(String roleId){
        List<String> menuList = sysRoleMenuMapper.findMenuByRoleId(roleId);
        return menuList;
    }

    @Override
    public boolean preInsert(SysRoleMenu data) {
        if (StringUtils.isBlank(data.getId())) {
            data.setId(keyGenerator.getNext());
        }
        data.setCreatedTime(new Timestamp(new Date().getTime()));
        return super.preInsert(data);
    }

    @Override
    public boolean preUpdate(SysRoleMenu data){
        SysRoleMenu sysRole = findById(data.getId());
        data.setCreatedTime(sysRole.getCreatedTime());
        return super.preUpdate(data);
    }
}
