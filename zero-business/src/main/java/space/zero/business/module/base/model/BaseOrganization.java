package space.zero.business.module.base.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import space.zero.core.model.BaseEntity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "base_organization")
public class BaseOrganization extends BaseEntity {
    /**
     * 组织id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 父id
     */
    @Column(name = "PARENT_ID")
    private String parentId;

    /**
     * 组织名称
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 组织邮箱
     */
    @Column(name = "EMAIL")
    private String email;

    /**
     * 备注
     */
    @Column(name = "REMARK")
    private String remark;

    /**
     * 邮编
     */
    @Column(name = "POST_CODE")
    private String postCode;

    /**
     * 是否启用
     */
    @Column(name = "IS_ENABLE")
    private String isEnable;

    /**
     * 创建时间
     */
    @Column(name = "CREATED_TIME")
    private Date createdTime;

    /**
     * 更新时间
     */
    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    /**
     * 创建人
     */
    @Column(name = "CREATED_USER")
    private String createdUser;

    /**
     * 类型
     */
    @Column(name = "TYPE")
    private String type;

    /**
     * 电话
     */
    @Column(name = "TEL")
    private String tel;

    /**
     * 是否删除(1:删除  0:未删除)
     */
    @JsonIgnore
    @Column(name = "IS_DELETE")
    private String isDelete;

    /**
     * 描述
     */
    @Column(name = "DESCRIPTION")
    private String description;

    /**
     * 获取组织id
     *
     * @return ID - 组织id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置组织id
     *
     * @param id 组织id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取父id
     *
     * @return PARENT_ID - 父id
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置父id
     *
     * @param parentId 父id
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取组织名称
     *
     * @return NAME - 组织名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置组织名称
     *
     * @param name 组织名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取组织邮箱
     *
     * @return EMAIL - 组织邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置组织邮箱
     *
     * @param email 组织邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取备注
     *
     * @return REMARK - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取邮编
     *
     * @return POST_CODE - 邮编
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * 设置邮编
     *
     * @param postCode 邮编
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    /**
     * 获取是否启用
     *
     * @return IS_ENABLE - 是否启用
     */
    public String getIsEnable() {
        return isEnable;
    }

    /**
     * 设置是否启用
     *
     * @param isEnable 是否启用
     */
    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }

    /**
     * 获取创建时间
     *
     * @return CREATED_TIME - 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置创建时间
     *
     * @param createdTime 创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取更新时间
     *
     * @return UPDATE_TIME - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取创建人
     *
     * @return CREATED_USER - 创建人
     */
    public String getCreatedUser() {
        return createdUser;
    }

    /**
     * 设置创建人
     *
     * @param createdUser 创建人
     */
    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * 获取类型
     *
     * @return TYPE - 类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置类型
     *
     * @param type 类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取电话
     *
     * @return TEL - 电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置电话
     *
     * @param tel 电话
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取是否删除(1:删除  0:未删除)
     *
     * @return IS_DELETE - 是否删除(1:删除  0:未删除)
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否删除(1:删除  0:未删除)
     *
     * @param isDelete 是否删除(1:删除  0:未删除)
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 获取描述
     *
     * @return DESCRIPTION - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }
}