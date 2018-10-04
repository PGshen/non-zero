package space.zero.business.module.official.website.service;

import space.zero.business.module.official.website.model.OfficialWebsiteClassMate;
import space.zero.business.module.official.website.param.response.ClazzListResponse;
import space.zero.core.service.Service;

import java.util.List;


/**
 * Created by PG_shen on 2018/10/04.
 */
public interface OfficialWebsiteClassMateService extends Service<OfficialWebsiteClassMate> {
    List<ClazzListResponse> findClazz(String clazzName);

}
