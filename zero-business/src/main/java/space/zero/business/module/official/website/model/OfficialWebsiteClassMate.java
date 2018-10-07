package space.zero.business.module.official.website.model;

import space.zero.business.module.official.website.base.WebsiteEntity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "official_website_class_mate")
public class OfficialWebsiteClassMate extends WebsiteEntity {
    /**
     * 类别ID
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 类别名称
     */
    @Column(name = "CLAZZ_NAME")
    private String clazzName;

    /**
     * 类别值
     */
    @Column(name = "CLAZZ_VALUE")
    private String clazzValue;

    /**
     * 备注
     */
    @Column(name = "REMARK")
    private String remark;

    /**
     * 是否删除1:删除 0:未删除
     */
    @Column(name = "IS_DELETE")
    private String isDelete;

    /**
     * 是否启用1:启用 0:不启用
     */
    @Column(name = "IS_ENABLE")
    private String isEnable;

    /**
     * 最近更新时间
     */
    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    /**
     * 创建时间
     */
    @Column(name = "CREATED_TIME")
    private Date createdTime;

    /**
     * 最近修改人
     */
    @Column(name = "UPDATE_USER")
    private String updateUser;

    /**
     * 获取类别ID
     *
     * @return ID - 类别ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置类别ID
     *
     * @param id 类别ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取类别名称
     *
     * @return CLAZZ_NAME - 类别名称
     */
    public String getClazzName() {
        return clazzName;
    }

    /**
     * 设置类别名称
     *
     * @param clazzName 类别名称
     */
    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    /**
     * 获取类别值
     *
     * @return CLAZZ_VALUE - 类别值
     */
    public String getClazzValue() {
        return clazzValue;
    }

    /**
     * 设置类别值
     *
     * @param clazzValue 类别值
     */
    public void setClazzValue(String clazzValue) {
        this.clazzValue = clazzValue;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取是否删除1:删除 0:未删除
     *
     * @return IS_DELETE - 是否删除1:删除 0:未删除
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否删除1:删除 0:未删除
     *
     * @param isDelete 是否删除1:删除 0:未删除
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 获取是否启用1:启用 0:不启用
     *
     * @return IS_ENABLE - 是否启用1:启用 0:不启用
     */
    public String getIsEnable() {
        return isEnable;
    }

    /**
     * 设置是否启用1:启用 0:不启用
     *
     * @param isEnable 是否启用1:启用 0:不启用
     */
    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }

    /**
     * 获取最近更新时间
     *
     * @return UPDATE_TIME - 最近更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置最近更新时间
     *
     * @param updateTime 最近更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
     * 获取最近修改人
     *
     * @return UPDATE_USER - 最近修改人
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * 设置最近修改人
     *
     * @param updateUser 最近修改人
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
}