package space.zero.business.module.sys.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import space.zero.business.module.sys.model.SysRoleMenu;
import space.zero.core.mapper.Mapper;

import java.util.List;


/**
 * Created by PG_shen on 2018/03/08.
 */
@Component
public interface SysRoleMenuMapper extends Mapper<SysRoleMenu> {
    @Select("select distinct m.PERM from sys_role_menu r_m, sys_menu m, sys_role r where r_m.MENU_ID=m.ID and r_m.ROLE_ID=r.ID and r_m.IS_DELETE=0 and r.NAME=#{role}")
    List<String> getPermsByRole(String role);

    @Select("select distinct m.PERM from sys_role_menu r_m, sys_menu m, sys_role r where r_m.MENU_ID=m.ID and r_m.ROLE_ID=r.ID and r_m.IS_DELETE=0 and r.ID=#{roleId}")
    List<String> getPermsByRoleId(String roleId);

    @Select("select MENU_ID from sys_role_menu where IS_DELETE=0 and role_id=#{roleId}")
    List<String> findAuthByRoleId(String roleId);

    //只查找菜单,不需请求跟按钮
    @Select("select r_m.MENU_ID from sys_role_menu r_m, sys_menu m where r_m.MENU_ID=m.ID and r_m.IS_DELETE=0 and m.type=0 and r_m.role_id=#{roleId}")
    List<String> findMenuByRoleId(String roleId);

    //根据菜单ID查找该菜单下的权限按钮
    @Select("select distinct m.PERM from sys_role_menu r_m, sys_menu m where r_m.MENU_ID=m.ID and r_m.IS_DELETE=0 and m.type=2 and r_m.role_id=${roleId} and m.parent_id=${parentId}")
    List<String> findButtonByParentId(@Param("roleId") String roleId, @Param("parentId") String parentId);
}
