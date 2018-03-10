package space.zero.business.module.sys.service.impl;

import space.zero.business.module.sys.dao.SysMenuMapper;
import space.zero.business.module.sys.model.SysMenu;
import space.zero.business.module.sys.param.response.SysMenuTree;
import space.zero.business.module.sys.service.SysMenuService;
import space.zero.core.service.AbstractDeleteFlagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by PG_shen on 2018/03/08.
 */
@Service
@Transactional
public class SysMenuServiceImpl extends AbstractDeleteFlagService<SysMenu> implements SysMenuService {
    @Resource
    private SysMenuMapper sysMenuMapper;

    public SysMenuTree getSysMenuTree(){
        SysMenuTree sysMenuTree = null;
        SysMenu sysMenu = sysMenuMapper.findRoot();
        if (null != sysMenu){
            sysMenuTree = new SysMenuTree();
            sysMenuTree.setId(sysMenu.getId());
            sysMenuTree.setName(sysMenu.getName());
            sysMenuTree.setDisplayName(sysMenu.getDisplayName());
            sysMenuTree.setUrl(sysMenu.getUrl());
            sysMenuTree.setIconClass(sysMenu.getIconClass());
            sysMenuTree.setIconUrl(sysMenu.getIconUrl());
            sysMenuTree.setPerms(sysMenu.getPerms());
            sysMenuTree.setType(sysMenu.getType());
            sysMenuTree.setOrderNum(sysMenu.getOrderNum());
            sysMenuTree.setIsShow(sysMenu.getIsShow());

            sysMenuTree.setChildren(getChildren(sysMenuTree.getId()));
        }
        return sysMenuTree;
    }

    public List<SysMenuTree> getChildren(String parentId){
        List<SysMenuTree> sysMenuTrees = null;
        List<SysMenu> sysMenus = sysMenuMapper.findByParentId(parentId);

        if (sysMenus.size() <= 0){
            return sysMenuTrees;
        }

        sysMenuTrees = new ArrayList<>();

        for (int i = 0; i < sysMenus.size(); i++){
            SysMenuTree sysMenuTree = new SysMenuTree();
            sysMenuTree.setId(sysMenus.get(i).getId());
            sysMenuTree.setParentId(parentId);
            sysMenuTree.setName(sysMenus.get(i).getName());
            sysMenuTree.setDisplayName(sysMenus.get(i).getDisplayName());
            sysMenuTree.setUrl(sysMenus.get(i).getUrl());
            sysMenuTree.setIconClass(sysMenus.get(i).getIconClass());
            sysMenuTree.setIconUrl(sysMenus.get(i).getIconUrl());
            sysMenuTree.setPerms(sysMenus.get(i).getPerms());
            sysMenuTree.setType(sysMenus.get(i).getType());
            sysMenuTree.setOrderNum(sysMenus.get(i).getOrderNum());
            sysMenuTree.setIsShow(sysMenus.get(i).getIsShow());

            sysMenuTree.setChildren(getChildren(sysMenuTree.getId()));

            sysMenuTrees.add(sysMenuTree);
        }

        return sysMenuTrees;
    }

    @Override
    public boolean preInsert(SysMenu data) {
        data.setCreatedTime(new Timestamp(new Date().getTime()));
        data.setUpdateTime(new Timestamp(new Date().getTime()));
        return super.preInsert(data);
    }

    @Override
    public boolean preUpdate(SysMenu data){
        data.setUpdateTime(new Timestamp(new Date().getTime()));
        return super.preUpdate(data);
    }

}
