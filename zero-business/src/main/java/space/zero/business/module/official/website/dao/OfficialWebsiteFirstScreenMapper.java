package space.zero.business.module.official.website.dao;

import org.apache.ibatis.annotations.Select;
import space.zero.business.module.official.website.model.OfficialWebsiteFirstScreen;
import space.zero.core.mapper.Mapper;


/**
 * Created by PG_shen on 2018/09/26.
 */
public interface OfficialWebsiteFirstScreenMapper extends Mapper<OfficialWebsiteFirstScreen> {
    @Select("select * from official_website_first_screen where is_enable = 1 and is_delete = 0 and first_screen_class = #{firstScreenClazz} order by update_time desc limit 1")
    OfficialWebsiteFirstScreen fetchFirstScreen(String firstScreenClazz);
}
