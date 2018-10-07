package space.zero.business.module.official.website.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import space.zero.business.module.official.website.model.OfficialWebsiteBaseInfo;
import space.zero.core.mapper.Mapper;


/**
 * Created by PG_shen on 2018/09/26.
 */
public interface OfficialWebsiteBaseInfoMapper extends Mapper<OfficialWebsiteBaseInfo> {
    @Select("select * from official_website_base_info where is_enable = 1 order by update_time desc limit 1")
    OfficialWebsiteBaseInfo fetchInfo();

    @Update("update official_website_base_info set is_enable = 0 where is_enable=1")
    void setAllDisable();
}
