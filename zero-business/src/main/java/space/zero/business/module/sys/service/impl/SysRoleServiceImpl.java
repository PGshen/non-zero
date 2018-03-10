package space.zero.business.module.sys.service.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import space.zero.business.module.sys.dao.SysRoleMapper;
import space.zero.business.module.sys.model.SysRole;
import space.zero.business.module.sys.model.SysRoleMenu;
import space.zero.business.module.sys.param.response.RoleListResponse;
import space.zero.business.module.sys.service.SysRoleMenuService;
import space.zero.business.module.sys.service.SysRoleService;
import space.zero.common.utils.StringUtils;
import space.zero.core.service.AbstractDeleteFlagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * Created by PG_shen on 2018/03/08.
 */
@Service
@Transactional
public class SysRoleServiceImpl extends AbstractDeleteFlagService<SysRole> implements SysRoleService {
    @Resource
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    /***
     * 对指定角色授权
     *
     * @param roleId 角色ID
     * @param menus 菜单列表
     * @return
     */
    public boolean roleAuth(String roleId, List<String> menus){
        boolean isExist = false;
        SysRoleMenu sysRoleMenu = null;
        List<SysRoleMenu> insertList = Lists.newArrayList();
        List<SysRoleMenu> sysRoleMenusOld = sysRoleMenuService.findAllByRoleId(roleId);
        // 设置全部删除
        for (SysRoleMenu sysRoleMenuIt : sysRoleMenusOld){
            sysRoleMenuIt.setIsDelete("1");
        }
        for (String menuId : menus){
            if (sysRoleMenusOld.size() <= 0){
                sysRoleMenu = new SysRoleMenu();
                sysRoleMenu.setRoleId(roleId);
                sysRoleMenu.setMenuId(menuId);
                insertList.add(sysRoleMenu);
            } else {
                for(SysRoleMenu sysRoleMenuIt : sysRoleMenusOld){
                    if(StringUtils.equals(sysRoleMenuIt.getRoleId(), roleId) && StringUtils.equals(sysRoleMenuIt.getMenuId(), menuId)){
                        sysRoleMenuIt.setIsDelete("0");
                        isExist = true;
                    }
                }

                if (!isExist){
                    sysRoleMenu = new SysRoleMenu();
                    sysRoleMenu.setRoleId(roleId);
                    sysRoleMenu.setMenuId(menuId);
                    insertList.add(sysRoleMenu);
                }

                isExist = false;
            }
        }

        for (SysRoleMenu sysRoleMenuIt : sysRoleMenusOld)
            sysRoleMenuService.update(sysRoleMenuIt);

        for (SysRoleMenu sysRoleMenuIt : insertList)
            sysRoleMenuService.save(sysRoleMenuIt);

        return true;
    }

    /***
     * 获取角色的菜单权限列表
     *
     * @param roleId
     * @return
     */
    public List<String> findAuthList(String roleId){
        return sysRoleMenuService.findAuthList(roleId);
    }

    /***
     * 用于获取所有角色（id，name），给用户管理时分配角色
     *
     * @return
     */
    public List<RoleListResponse> findRoleListForAuth(){
        return sysRoleMapper.findRoleListForAuth();
    }

    @Override
    public boolean preInsert(SysRole data) {
        data.setCreatedTime(new Timestamp(new Date().getTime()));
        return super.preInsert(data);
    }

    @Override
    public boolean preUpdate(SysRole data){
        SysRole sysRole = findById(data.getId());
        data.setCreatedTime(sysRole.getCreatedTime());
        return super.preUpdate(data);
    }
}
