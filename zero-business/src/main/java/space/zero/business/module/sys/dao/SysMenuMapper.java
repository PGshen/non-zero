package space.zero.business.module.sys.dao;

import org.apache.ibatis.annotations.Select;
import space.zero.business.module.sys.model.SysMenu;
import space.zero.core.mapper.Mapper;

import java.util.List;


/**
 * Created by PG_shen on 2018/03/08.
 */
public interface SysMenuMapper extends Mapper<SysMenu> {
    @Select("select * from sys_menu where is_delete = 0 and parent_id = #{parentId}")
    List<SysMenu> findByParentId(String parentId);

    @Select("select * from sys_menu where is_delete = 0 and id = 0")
    SysMenu findRoot();
}
