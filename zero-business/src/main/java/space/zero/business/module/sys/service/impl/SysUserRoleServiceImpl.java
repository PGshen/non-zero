package space.zero.business.module.sys.service.impl;

import space.zero.business.module.sys.dao.SysUserRoleMapper;
import space.zero.business.module.sys.model.SysRole;
import space.zero.business.module.sys.model.SysUserRole;
import space.zero.business.module.sys.service.SysUserRoleService;
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
public class SysUserRoleServiceImpl extends AbstractDeleteFlagService<SysUserRole> implements SysUserRoleService {
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    /**
     * 给用户分配角色
     * @param userId
     * @param roleIds
     */
    @Transactional
    public void addRoles(String userId, List<String> roleIds) {
        if (roleIds != null && roleIds.size()>0){
            for(String tmp : roleIds) {
                SysUserRole userRole = new SysUserRole();
                userRole.setUserId(userId);
                userRole.setRoleId(tmp);
                userRole.setCreatedTime(new Timestamp(new Date().getTime()));
                userRole.setUpdateTime(new Timestamp(new Date().getTime()));
                userRole.setIsDelete("0");
                this.save(userRole);
            }
        }
    }

    public List<SysRole> getRolesByUserId(String userId) {
        return sysUserRoleMapper.findSysRolesByUserId(userId);
    }

    public List<String> getRoleByUserId(String userId){
        return sysUserRoleMapper.findRolesByUserId(userId);
    }

    public void deleteAllRolesByUserId(String userId) {
        sysUserRoleMapper.deleteByUserId(userId);
    }

    /**
     * 更新用户角色
     * @param userId
     * @param roleIds
     */
    @Transactional
    public void updateRoles(String userId, List<String> roleIds) {
        deleteAllRolesByUserId(userId);
        addRoles(userId, roleIds);
    }

    @Override
    public boolean preInsert(SysUserRole data) {
        data.setCreatedTime(new Timestamp(new Date().getTime()));
        return super.preInsert(data);
    }

    @Override
    public boolean preUpdate(SysUserRole data){
        SysUserRole sysRole = findById(data.getId());
        data.setCreatedTime(sysRole.getCreatedTime());
        return super.preUpdate(data);
    }
}
