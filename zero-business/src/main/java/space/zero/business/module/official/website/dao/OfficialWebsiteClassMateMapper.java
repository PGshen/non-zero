package space.zero.business.module.official.website.dao;

import org.apache.ibatis.annotations.Select;
import space.zero.business.module.official.website.model.OfficialWebsiteClassMate;
import space.zero.business.module.official.website.param.response.ClazzListResponse;
import space.zero.core.mapper.Mapper;

import java.util.List;


/**
 * Created by PG_shen on 2018/10/04.
 */
public interface OfficialWebsiteClassMateMapper extends Mapper<OfficialWebsiteClassMate> {
    @Select("select id, clazz_value from official_website_class_mate where is_delete=0 and clazz_name = #{clazzName}")
    List<ClazzListResponse> findClazz(String clazzName);
}
