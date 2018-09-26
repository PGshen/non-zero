package space.zero.business.module.official.website.model;

import space.zero.core.model.BaseEntity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "official_website_history")
public class OfficialWebsiteHistory extends BaseEntity {
    /**
     * 企业历程id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 年份
     */
    @Column(name = "YEAR")
    private String year;

    /**
     * 月份
     */
    @Column(name = "MONTH")
    private String month;

    /**
     * 描述
     */
    @Column(name = "DESCRIPTION")
    private String description;

    /**
     * 启用标识 1：启用 0：不启用
     */
    @Column(name = "IS_ENABLE")
    private String isEnable;

    /**
     * 删除标识 1：删除 0：未删除
     */
    @Column(name = "IS_DELETE")
    private String isDelete;

    /**
     * 更新时间
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
     * 获取企业历程id
     *
     * @return ID - 企业历程id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置企业历程id
     *
     * @param id 企业历程id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取年份
     *
     * @return YEAR - 年份
     */
    public String getYear() {
        return year;
    }

    /**
     * 设置年份
     *
     * @param year 年份
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * 获取月份
     *
     * @return MONTH - 月份
     */
    public String getMonth() {
        return month;
    }

    /**
     * 设置月份
     *
     * @param month 月份
     */
    public void setMonth(String month) {
        this.month = month;
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

    /**
     * 获取启用标识 1：启用 0：不启用
     *
     * @return IS_ENABLE - 启用标识 1：启用 0：不启用
     */
    public String getIsEnable() {
        return isEnable;
    }

    /**
     * 设置启用标识 1：启用 0：不启用
     *
     * @param isEnable 启用标识 1：启用 0：不启用
     */
    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }

    /**
     * 获取删除标识 1：删除 0：未删除
     *
     * @return IS_DELETE - 删除标识 1：删除 0：未删除
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 设置删除标识 1：删除 0：未删除
     *
     * @param isDelete 删除标识 1：删除 0：未删除
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
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