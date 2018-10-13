package space.zero.business.module.sys.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import space.zero.core.model.BaseEntity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_role")
public class SysRole extends BaseEntity {
    /**
     * 角色id
     */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 角色名称
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 别名
     */
    @Column(name = "ALIAS")
    private String alias;

    /**
     * 角色描述
     */
    @Column(name = "DESCRIPTION")
    private String description;

    /**
     * 状态标志（0：禁用  1：启用）
     */
    @Column(name = "IS_ENABLE")
    private transient String isEnable;

    /**
     * 删除标志（0：禁用   1：删除）
     */
    @JsonIgnore
    @Column(name = "IS_DELETE")
    private transient String isDelete;

    @Column(name = "CREATED_TIME")
    private Date createdTime;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    public SysRole(){
        super();
    }

    public SysRole(String name){
        super();
        this.name = name;
    }

    /**
     * 获取角色id
     *
     * @return ID - 角色id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置角色id
     *
     * @param id 角色id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取角色名称
     *
     * @return NAME - 角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置角色名称
     *
     * @param name 角色名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取别名
     *
     * @return ALIAS - 别名
     */
    public String getAlias() {
        return alias;
    }

    /**
     * 设置别名
     *
     * @param alias 别名
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * 获取角色描述
     *
     * @return DESCRIPTION - 角色描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置角色描述
     *
     * @param description 角色描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取状态标志（0：禁用  1：启用）
     *
     * @return IS_ENABLE - 状态标志（0：禁用  1：启用）
     */
    public String getIsEnable() {
        return isEnable;
    }

    /**
     * 设置状态标志（0：禁用  1：启用）
     *
     * @param isEnable 状态标志（0：禁用  1：启用）
     */
    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }

    /**
     * 获取删除标志（0：禁用   1：删除）
     *
     * @return IS_DELETE - 删除标志（0：禁用   1：删除）
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 设置删除标志（0：禁用   1：删除）
     *
     * @param isDelete 删除标志（0：禁用   1：删除）
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