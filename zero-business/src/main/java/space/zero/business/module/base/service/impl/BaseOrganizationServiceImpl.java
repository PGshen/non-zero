package space.zero.business.module.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import space.zero.business.module.base.dao.BaseOrganizationMapper;
import space.zero.business.module.base.model.BaseOrganization;
import space.zero.business.module.base.param.response.BaseOrganizationTree;
import space.zero.business.module.base.service.BaseOrganizationService;
import space.zero.business.module.sys.model.SysUserDetails;
import space.zero.common.keyGenerator.KeyGenerator;
import space.zero.common.utils.StringUtils;
import space.zero.core.service.AbstractDeleteFlagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by PG_shen on 2018/03/17.
 */
@Service
@Transactional
public class BaseOrganizationServiceImpl extends AbstractDeleteFlagService<BaseOrganization> implements BaseOrganizationService {
    @Resource
    private BaseOrganizationMapper baseOrganizationMapper;

    @Autowired
    KeyGenerator<String> keyGenerator;

    public BaseOrganizationTree getOrgTree(){
        BaseOrganizationTree baseOrganizationTree = new BaseOrganizationTree();
        List<BaseOrganizationTree> children = new ArrayList<>();
        List<BaseOrganization> baseOrganizations = baseOrganizationMapper.findAllOrganization();
        for (int i = 0; i < baseOrganizations.size(); i++){
            BaseOrganizationTree baseOrganizationTreeTmp = new BaseOrganizationTree(baseOrganizations.get(i).getId(),
                    baseOrganizations.get(i).getParentId(),
                    baseOrganizations.get(i).getName(),
                    baseOrganizations.get(i).getEmail(),
                    baseOrganizations.get(i).getRemark(),
                    baseOrganizations.get(i).getPostCode(),
                    baseOrganizations.get(i).getType(),
                    baseOrganizations.get(i).getTel(),
                    baseOrganizations.get(i).getDescription());
            baseOrganizationTreeTmp.setChildren(getChildren(baseOrganizations.get(i).getId()));

            children.add(baseOrganizationTreeTmp);
        }

        baseOrganizationTree.setChildren(children);

        return baseOrganizationTree;
    }

    public List<BaseOrganizationTree> getChildren(String parentId){
        if (StringUtils.isEmpty(parentId)){
            return null;
        }

        List<BaseOrganizationTree> children = new ArrayList<>();

        List<BaseOrganization> baseOrganizations = baseOrganizationMapper.findByParentID(parentId);
        for (int i = 0; i < baseOrganizations.size(); i++){
            BaseOrganizationTree baseOrganizationTreeTmp = new BaseOrganizationTree(baseOrganizations.get(i).getId(),
                    baseOrganizations.get(i).getParentId(),
                    baseOrganizations.get(i).getName(),
                    baseOrganizations.get(i).getEmail(),
                    baseOrganizations.get(i).getRemark(),
                    baseOrganizations.get(i).getPostCode(),
                    baseOrganizations.get(i).getType(),
                    baseOrganizations.get(i).getTel(),
                    baseOrganizations.get(i).getDescription());

            baseOrganizationTreeTmp.setChildren(getChildren(baseOrganizations.get(i).getId()));

            children.add(baseOrganizationTreeTmp);
        }

        return children;
    }

    @Override
    public boolean preInsert(BaseOrganization data){
        if (StringUtils.isEmpty(data.getId())){
            data.setId(keyGenerator.getNext());
        }

        // 公司则父节点id为0
        if (StringUtils.isEmpty(data.getParentId())){
            data.setParentId("0");
        }
        data.setCreatedTime(new Date());
        data.setUpdateTime(new Date());
        SysUserDetails sysUserDetails = (SysUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        data.setCreatedUser(sysUserDetails.getUser().getName());
        return super.preInsert(data);
    }

}
