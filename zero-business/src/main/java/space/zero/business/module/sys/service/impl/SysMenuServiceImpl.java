package space.zero.business.module.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import space.zero.business.module.sys.dao.SysMenuMapper;
import space.zero.business.module.sys.model.SysMenu;
import space.zero.business.module.sys.model.SysUserDetails;
import space.zero.business.module.sys.param.response.RouterTree;
import space.zero.business.module.sys.param.response.SysMenuTree;
import space.zero.business.module.sys.service.SysMenuService;
import space.zero.business.module.sys.service.SysRoleMenuService;
import space.zero.business.module.sys.service.SysUserRoleService;
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
    private SysRoleMenuService sysRoleMenuService;
    @Autowired
    private SysUserRoleService sysUserRoleService;
    @Autowired
    private KeyGenerator<String> keyGenerator;

    public SysMenuTree getSysMenuTree() {
        SysMenuTree sysMenuTree = null;
        SysMenu sysMenu = sysMenuMapper.findRoot();
        if (null != sysMenu) {
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
            sysMenuTree.setUrl(sysMenu.getUrl());
            sysMenuTree.setMethod(sysMenu.getMethod());

            sysMenuTree.setChildren(getChildren(sysMenuTree.getId()));
        }
        return sysMenuTree;
    }

    public List<RouterTree> getMenuByMenuIds(List<String> menuIds,List<String> roles, String parentId) {
        //为空时表示没有任何权限
        if (menuIds.size() < 1) {
            return null;
        }
        List<RouterTree> routerTrees = null;
        List<SysMenu> sysMenus = sysMenuMapper.findByParentId(parentId);

        if (sysMenus.size() <= 0) {
            return routerTrees;
        }

        routerTrees = new ArrayList<>();

        for (int i = 0; i < sysMenus.size(); i++) {
            SysMenu tmp = sysMenus.get(i);
            for (String menuId : menuIds) {
                if (menuId.equals(tmp.getId())) {
                    RouterTree routerTree = new RouterTree();
                    routerTree.setId(tmp.getId());
                    routerTree.setName(tmp.getName());
                    routerTree.setTitle(tmp.getTitle());
                    routerTree.setPath(tmp.getPath());
                    routerTree.setIcon(tmp.getIcon());
                    routerTree.setOrderNum(tmp.getOrderNum());
                    routerTree.setHidden(tmp.getHidden());
                    routerTree.setAlwaysShow(tmp.getAlwaysShow());
                    routerTree.setComponent(tmp.getComponent());
                    routerTree.setRedirect(tmp.getRedirect());
                    routerTree.setUrl(tmp.getUrl());

                    routerTree.setBtn(getButtonByRolesAndParentId(roles, routerTree.getId()));

                    routerTree.setChildren(getMenuByMenuIds(menuIds, roles, routerTree.getId()));

                    routerTrees.add(routerTree);
                    break;
                }
            }
        }

        return routerTrees;
    }

    public List<RouterTree> getMenuByRoles(List<String> roleIds) {

        SysUserDetails sysUserDetails = (SysUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<String> roles = sysUserRoleService.getRoleByUserId(sysUserDetails.getUser().getId());
        Set<String> tmp = new HashSet<>();
        for (String roleId : roleIds) {
            List<String> authList = sysRoleMenuService.findMenuList(roleId);
            if (authList.size() > 0) {
                tmp.addAll(new HashSet<>(authList));
            }
        }

        List<String> menuIds = null;
        if (tmp.size() > 0) {
            menuIds = new ArrayList<>(tmp);
        }
        return getMenuByMenuIds(menuIds, roles, "0");
    }

    public String getButtonByRolesAndParentId(List<String> roleIds, String parentId) {
        Set<String> tmp = new HashSet<>();
        for (String roleId : roleIds) {
            List<String> authList = sysRoleMenuService.findButtonList(roleId, parentId);
            if (authList.size() > 0) {
                tmp.addAll(new HashSet<>(authList));
            }
        }

        List<String> btnList = null;
        if (tmp.size() > 0) {
            btnList = new ArrayList<>(tmp);
            return String.join(",", btnList);
        }
        return "";
    }

    public List<SysMenuTree> getChildren(String parentId) {
        List<SysMenuTree> sysMenuTrees = null;
        List<SysMenu> sysMenus = sysMenuMapper.findByParentId(parentId);

        if (sysMenus.size() <= 0) {
            return sysMenuTrees;
        }

        sysMenuTrees = new ArrayList<>();

        for (int i = 0; i < sysMenus.size(); i++) {
            SysMenu tmp = sysMenus.get(i);
            SysMenuTree sysMenuTree = new SysMenuTree();
            sysMenuTree.setId(tmp.getId());
            sysMenuTree.setParentId(parentId);
            sysMenuTree.setName(tmp.getName());
            sysMenuTree.setTitle(tmp.getTitle());
            sysMenuTree.setPath(tmp.getPath());
            sysMenuTree.setIcon(tmp.getIcon());
            sysMenuTree.setPerm(tmp.getPerm());
            sysMenuTree.setType(tmp.getType());
            sysMenuTree.setOrderNum(tmp.getOrderNum());
            sysMenuTree.setHidden(tmp.getHidden());
            sysMenuTree.setAlwaysShow(tmp.getAlwaysShow());
            sysMenuTree.setComponent(tmp.getComponent());
            sysMenuTree.setRedirect(tmp.getRedirect());
            sysMenuTree.setUrl(tmp.getUrl());
            sysMenuTree.setMethod(tmp.getMethod());

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
        SysUserDetails sysUserDetails = (SysUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        data.setCreateUser(sysUserDetails.getUser().getName());
        data.setCreatedTime(new Timestamp(new Date().getTime()));
        data.setUpdateTime(new Timestamp(new Date().getTime()));
        return super.preInsert(data);
    }

    @Override
    public boolean preUpdate(SysMenu data) {
        data.setUpdateTime(new Timestamp(new Date().getTime()));
        return super.preUpdate(data);
    }

}
