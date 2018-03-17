package space.zero.business.module.sys.model;

import space.zero.core.model.BaseEntity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_user_role")
public class SysUserRole extends BaseEntity {
    /**
     * 主键
     */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 用户id
     */
    @Column(name = "USER_ID")
    private String userId;

    /**
     * 角色id
     */
    @Column(name = "ROLE_ID")
    private String roleId;

    @Column(name = "CREATED_TIME")
    private Date createdTime;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    /**
     * 假删除
     */
    @Column(name = "IS_DELETE")
    private transient String isDelete;

    /**
     * 获取主键
     *
     * @return ID - 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return USER_ID - 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取角色id
     *
     * @return ROLE_ID - 角色id
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * 设置角色id
     *
     * @param roleId 角色id
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
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

    /**
     * 获取假删除
     *
     * @return IS_DELETE - 假删除
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 设置假删除
     *
     * @param isDelete 假删除
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
}