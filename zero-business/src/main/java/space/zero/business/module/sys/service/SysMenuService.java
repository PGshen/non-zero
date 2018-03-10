package space.zero.business.module.sys.service;

import space.zero.business.module.sys.model.SysMenu;
import space.zero.business.module.sys.param.response.SysMenuTree;
import space.zero.core.service.Service;

import java.util.List;


/**
 * Created by PG_shen on 2018/03/08.
 */
public interface SysMenuService extends Service<SysMenu> {
    List<SysMenuTree> getChildren(String parentId);

    SysMenuTree getSysMenuTree();
}
