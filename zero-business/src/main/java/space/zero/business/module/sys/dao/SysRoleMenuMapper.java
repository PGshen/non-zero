package space.zero.business.module.sys.dao;

import org.apache.ibatis.annotations.Select;
import space.zero.business.module.sys.model.SysRoleMenu;
import space.zero.core.mapper.Mapper;

import java.util.List;


/**
 * Created by PG_shen on 2018/03/08.
 */
public interface SysRoleMenuMapper extends Mapper<SysRoleMenu> {
    @Select("select distinct m.`PERMS` from sys_role_menu r_m, sys_menu m, sys_role r where r_m.MENU_ID=m.ID and r_m.ROLE_ID=r.ID and r_m.IS_DELETE=0 and r.NAME=#{role}")
    List<String> getPermsByRole(String role);

    @Select("select distinct m.`PERMS` from sys_role_menu r_m, sys_menu m, sys_role r where r_m.MENU_ID=m.ID and r_m.ROLE_ID=r.ID and r_m.IS_DELETE=0 and r.ID=#{roleId}")
    List<String> getPermsByRoleId(String roleId);

    @Select("select MENU_ID from sys_role_menu where IS_DELETE=0 and role_id=#{roleId}")
    List<String> findAuthByRoleId(String roleId);
}
