package space.zero.business.module.official.website.service;

import space.zero.business.module.official.website.model.OfficialWebsiteNews;
import space.zero.core.service.Service;


/**
 * Created by PG_shen on 2018/09/26.
 */
public interface OfficialWebsiteNewsService extends Service<OfficialWebsiteNews> {

    OfficialWebsiteNews getNextNews(String id, String newsClazz);

    OfficialWebsiteNews getPreviousNews(String id, String newsClazz);
}
