package space.zero.business.module.sys.service;

import space.zero.business.module.sys.model.SysRole;
import space.zero.business.module.sys.model.SysUserRole;
import space.zero.core.service.Service;

import java.util.List;


/**
 * Created by PG_shen on 2018/03/08.
 */
public interface SysUserRoleService extends Service<SysUserRole> {
    void addRoles(String userId, List<String> roleIds);

    List<SysRole> getRolesByUserId(String userId);

    List<String> getRoleByUserId(String userId);

    void deleteAllRolesByUserId(String userId);

    void updateRoles(String userId, List<String> roleIds);
}
