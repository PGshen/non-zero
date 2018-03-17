package space.zero.business.module.base.dao;

import org.apache.ibatis.annotations.Select;
import space.zero.business.module.base.model.BaseOrganization;
import space.zero.core.mapper.Mapper;

import java.util.List;


/**
 * Created by PG_shen on 2018/03/17.
 */
public interface BaseOrganizationMapper extends Mapper<BaseOrganization> {
    @Select("select * from base_organization where is_delete = 0 and parent_id = 0") // 公司节点的parent_id为0
    List<BaseOrganization> findAllOrganization();

    @Select("select * from base_organization where is_delete=0 and parent_id=#{parentID}")
    List<BaseOrganization> findByParentID(String parentId);
}
