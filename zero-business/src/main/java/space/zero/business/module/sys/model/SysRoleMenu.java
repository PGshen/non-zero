package space.zero.business.module.sys.model;

import space.zero.core.model.BaseEntity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_role_menu")
public class SysRoleMenu extends BaseEntity {
    /**
     * 角色菜单ID
     */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 角色id（外键）
     */
    @Column(name = "ROLE_ID")
    private String roleId;

    /**
     * 菜单id（外键）
     */
    @Column(name = "MENU_ID")
    private String menuId;

    /**
     * 是否删除标志（所有记录都是假删除）
     */
    @Column(name = "IS_DELETE")
    private transient String isDelete;

    @Column(name = "CREATED_TIME")
    private Date createdTime;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    /**
     * 获取角色菜单ID
     *
     * @return ID - 角色菜单ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置角色菜单ID
     *
     * @param id 角色菜单ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取角色id（外键）
     *
     * @return ROLE_ID - 角色id（外键）
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * 设置角色id（外键）
     *
     * @param roleId 角色id（外键）
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取菜单id（外键）
     *
     * @return MENU_ID - 菜单id（外键）
     */
    public String getMenuId() {
        return menuId;
    }

    /**
     * 设置菜单id（外键）
     *
     * @param menuId 菜单id（外键）
     */
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    /**
     * 获取是否删除标志（所有记录都是假删除）
     *
     * @return IS_DELETE - 是否删除标志（所有记录都是假删除）
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否删除标志（所有记录都是假删除）
     *
     * @param isDelete 是否删除标志（所有记录都是假删除）
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * @return CREATED_TIME
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * @param createdTime
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * @return UPDATE_TIME
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}