package space.zero.business.module.sys.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import space.zero.business.module.sys.model.SysRole;
import space.zero.business.module.sys.model.SysUserRole;
import space.zero.core.mapper.Mapper;

import java.util.List;


/**
 * Created by PG_shen on 2018/03/08.
 */
@Component
public interface SysUserRoleMapper extends Mapper<SysUserRole> {
    @Select("select r.* from sys_role r, sys_user u, sys_user_role u_r where r.id = u_r.ROLE_ID and u_r.USER_ID = u.ID and u_r.IS_DELETE = 0 and u.ID = #{userId}")
    List<SysRole> findSysRolesByUserId(String userId);

    @Select("select ROLE_ID from sys_user_role where IS_DELETE=0 and user_id=#{userID}")
    List<String> findRolesByUserId(String userId);

    @Select("select r.`NAME` from sys_role r, sys_user u, sys_user_role u_r WHERE u.ID = u_r.USER_ID AND r.ID = u_r.ROLE_ID AND u_r.IS_DELETE=0 AND u.LOGIN_NAME = #{username}")
    List<String> getSysRolesByUsername(String username);

    @Delete("update sys_user_role set IS_DELETE=1 where user_id=#{userId}")
    void deleteByUserId(String userId);
}
