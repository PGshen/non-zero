package space.zero.business.module.sys.dao;

import org.apache.ibatis.annotations.Select;
import space.zero.business.module.sys.model.SysRole;
import space.zero.business.module.sys.param.response.RoleListResponse;
import space.zero.core.mapper.Mapper;

import java.util.List;


/**
 * Created by PG_shen on 2018/03/08.
 */
public interface SysRoleMapper extends Mapper<SysRole> {
    @Select("select id,name from sys_role where is_delete=0")
    List<RoleListResponse> findRoleListForAuth();
}
