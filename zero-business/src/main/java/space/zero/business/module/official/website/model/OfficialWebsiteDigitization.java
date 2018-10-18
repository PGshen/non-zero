package space.zero.business.module.official.website.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import space.zero.core.model.BaseEntity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "official_website_digitization")
public class OfficialWebsiteDigitization extends BaseEntity {
    /**
     * 企业数说id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 矢量图路径
     */
    @Column(name = "PIC")
    private String pic;

    /**
     * 数字
     */
    @Column(name = "DIGIT")
    private String digit;

    /**
     * 短描述
     */
    @Column(name = "SHORT_DESCRIPTION")
    private String shortDescription;

    /**
     * 启用标识 1：启用 0：不启用
     */
    @Column(name = "IS_ENABLE")
    private String isEnable;

    /**
     * 删除标识 1：删除 0：未删除
     */
    @JsonIgnore
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
    @JsonIgnore
    @Column(name = "UPDATE_USER")
    private String updateUser;

    /**
     * 获取企业数说id
     *
     * @return ID - 企业数说id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置企业数说id
     *
     * @param id 企业数说id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取矢量图路径
     *
     * @return PIC - 矢量图路径
     */
    public String getPic() {
        return pic;
    }

    /**
     * 设置矢量图路径
     *
     * @param pic 矢量图路径
     */
    public void setPic(String pic) {
        this.pic = pic;
    }

    /**
     * 获取数字
     *
     * @return DIGIT - 数字
     */
    public String getDigit() {
        return digit;
    }

    /**
     * 设置数字
     *
     * @param digit 数字
     */
    public void setDigit(String digit) {
        this.digit = digit;
    }

    /**
     * 获取短描述
     *
     * @return SHORT_DESCRIPTION - 短描述
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * 设置短描述
     *
     * @param shortDescription 短描述
     */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
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