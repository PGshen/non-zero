package space.zero.business.module.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import space.zero.business.module.sys.dao.SysMenuMapper;
import space.zero.business.module.sys.model.SysMenu;
import space.zero.business.module.sys.model.SysUserDetails;
import space.zero.business.module.sys.param.response.RouterTree;
import space.zero.business.module.sys.param.response.SysMenuTree;
import space.zero.business.module.sys.service.SysMenuService;
import space.zero.common.keyGenerator.KeyGenerator;
import space.zero.common.utils.StringUtils;
import space.zero.core.service.AbstractDeleteFlagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.*;


/**
 * Created by PG_shen on 2018/03/08.
 */
@Service
@Transactional
public class SysMenuServiceImpl extends AbstractDeleteFlagService<SysMenu> implements SysMenuService {
    @Resource
    private SysMenuMapper sysMenuMapper;
    @Autowired
    private SysRoleMenuServiceImpl sysRoleMenuService;
    @Autowired
    private KeyGenerator<String> keyGenerator;

    public SysMenuTree getSysMenuTree(){
        SysMenuTree sysMenuTree = null;
        SysMenu sysMenu = sysMenuMapper.findRoot();
        if (null != sysMenu){
            sysMenuTree = new SysMenuTree();
            sysMenuTree.setId(sysMenu.getId());
            sysMenuTree.setName(sysMenu.getName());
            sysMenuTree.setTitle(sysMenu.getTitle());
            sysMenuTree.setPath(sysMenu.getPath());
            sysMenuTree.setIcon(sysMenu.getIcon());
            sysMenuTree.setPerm(sysMenu.getPerm());
            sysMenuTree.setType(sysMenu.getType());
            sysMenuTree.setOrderNum(sysMenu.getOrderNum());
            sysMenuTree.setHidden(sysMenu.getHidden());
            sysMenuTree.setAlwaysShow(sysMenu.getAlwaysShow());
            sysMenuTree.setComponent(sysMenu.getComponent());
            sysMenuTree.setRedirect(sysMenu.getRedirect());

            sysMenuTree.setChildren(getChildren(sysMenuTree.getId()));
        }
        return sysMenuTree;
    }

    public List<RouterTree> getMenuByMenuIds(List<String> menuIds, String parentId){
        //为空时表示没有任何权限
        if (menuIds.size()<1){
            return null;
        }
        List<RouterTree> routerTrees = null;
        List<SysMenu> sysMenus = sysMenuMapper.findByParentId(parentId);

        if (sysMenus.size() <= 0){
            return routerTrees;
        }

        routerTrees = new ArrayList<>();

        for (int i = 0; i < sysMenus.size(); i++){
            for (String menuId : menuIds){
                if (menuId.equals(sysMenus.get(i).getId())){
                    RouterTree routerTree = new RouterTree();
                    routerTree.setId(sysMenus.get(i).getId());
                    routerTree.setName(sysMenus.get(i).getName());
                    routerTree.setTitle(sysMenus.get(i).getTitle());
                    routerTree.setPath(sysMenus.get(i).getPath());
                    routerTree.setIcon(sysMenus.get(i).getIcon());
                    routerTree.setOrderNum(sysMenus.get(i).getOrderNum());
                    routerTree.setHidden(sysMenus.get(i).getHidden());
                    routerTree.setAlwaysShow(sysMenus.get(i).getAlwaysShow());
                    routerTree.setComponent(sysMenus.get(i).getComponent());
                    routerTree.setRedirect(sysMenus.get(i).getRedirect());

                    routerTree.setChildren(getMenuByMenuIds(menuIds,routerTree.getId()));

                    routerTrees.add(routerTree);
                    break;
                }
            }
        }

        return routerTrees;
    }

    public List<RouterTree> getMenuByRoles(List<String> roleIds){
        Set<String> tmp = new HashSet<>();
        for (String roleId : roleIds){
            List<String> authList = sysRoleMenuService.findAuthList(roleId);
            if (authList.size()>0){
                tmp.addAll(new HashSet<>(authList));
            }
        }

        List<String> menuIds = null;
        if (tmp.size()>0){
            menuIds = new ArrayList<>(tmp);
        }
        return getMenuByMenuIds(menuIds, "0");
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
            sysMenuTree.setTitle(sysMenus.get(i).getTitle());
            sysMenuTree.setPath(sysMenus.get(i).getPath());
            sysMenuTree.setIcon(sysMenus.get(i).getIcon());
            sysMenuTree.setPerm(sysMenus.get(i).getPerm());
            sysMenuTree.setType(sysMenus.get(i).getType());
            sysMenuTree.setOrderNum(sysMenus.get(i).getOrderNum());
            sysMenuTree.setHidden(sysMenus.get(i).getHidden());
            sysMenuTree.setAlwaysShow(sysMenus.get(i).getAlwaysShow());
            sysMenuTree.setComponent(sysMenus.get(i).getComponent());
            sysMenuTree.setRedirect(sysMenus.get(i).getRedirect());

            sysMenuTree.setChildren(getChildren(sysMenuTree.getId()));

            sysMenuTrees.add(sysMenuTree);
        }

        return sysMenuTrees;
    }

    @Override
    public boolean preInsert(SysMenu data) {
        if (StringUtils.isBlank(data.getId())) {
            data.setId(keyGenerator.getNext());
        }
        SysUserDetails sysUserDetails = (SysUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        data.setCreateUser(sysUserDetails.getUser().getName());
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
