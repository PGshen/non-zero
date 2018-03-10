package space.zero.business.module.sys.service;

import space.zero.business.module.sys.model.SysRole;
import space.zero.business.module.sys.param.response.RoleListResponse;
import space.zero.core.service.Service;

import java.util.List;


/**
 * Created by PG_shen on 2018/03/08.
 */
public interface SysRoleService extends Service<SysRole> {

    boolean roleAuth(String roleId, List<String> menus);

    List<String> findAuthList(String roleID);

    List<RoleListResponse> findRoleListForAuth();
}
