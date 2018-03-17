package space.zero.business.module.base.service;

import space.zero.business.module.base.model.BaseOrganization;
import space.zero.business.module.base.param.response.BaseOrganizationTree;
import space.zero.core.service.Service;

import java.util.List;


/**
 * Created by PG_shen on 2018/03/17.
 */
public interface BaseOrganizationService extends Service<BaseOrganization> {
    BaseOrganizationTree getOrgTree();
    List<BaseOrganizationTree> getChildren(String parentId);
}
