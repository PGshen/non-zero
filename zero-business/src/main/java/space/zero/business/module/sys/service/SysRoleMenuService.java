package space.zero.business.module.sys.service;

import org.apache.ibatis.annotations.Select;
import space.zero.business.module.sys.model.SysRoleMenu;
import space.zero.core.service.Service;

import java.util.List;


/**
 * Created by PG_shen on 2018/03/08.
 */
public interface SysRoleMenuService extends Service<SysRoleMenu> {
    List<SysRoleMenu> findAllByRoleId(String roleId);

    List<String> findAuthList(String roleID);

    List<String> findMenuList(String roleId);

    List<String> findButtonList(String roleId, String parentId);
}
