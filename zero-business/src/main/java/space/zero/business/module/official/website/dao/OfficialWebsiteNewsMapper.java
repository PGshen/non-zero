package space.zero.business.module.official.website.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import space.zero.business.module.official.website.model.OfficialWebsiteNews;
import space.zero.core.mapper.Mapper;


/**
 * Created by PG_shen on 2018/09/26.
 */
public interface OfficialWebsiteNewsMapper extends Mapper<OfficialWebsiteNews> {
    @Select("select * from official_website_news where release_time > (select release_time from official_website_news where id = #{id}) and news_class = #{newsClass} and IS_DELETE=0 and status=1 order by release_time limit 1")
    OfficialWebsiteNews getNextNews(@Param("id")String id, @Param("newsClass")String newsClass);


    @Select("select * from official_website_news where release_time < (select release_time from official_website_news where id = #{id}) and news_class = #{newsClass} and IS_DELETE=0 and status=1 order by release_time desc limit 1")
    OfficialWebsiteNews getPreviousNews(@Param("id")String id, @Param("newsClass")String newsClass);
}
