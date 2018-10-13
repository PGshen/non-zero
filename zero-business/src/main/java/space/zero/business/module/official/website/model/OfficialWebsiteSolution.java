package space.zero.business.module.official.website.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import space.zero.business.module.official.website.base.WebsiteEntity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "official_website_solution")
public class OfficialWebsiteSolution extends WebsiteEntity {
    /**
     * 解决方案id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 一级标题
     */
    @Column(name = "FIRST_HEADING")
    private String firstHeading;

    /**
     * 二级标题
     */
    @Column(name = "SECONDARY_HEADING")
    private String secondaryHeading;

    /**
     * 三级标题
     */
    @Column(name = "TERTIARY_HEADING")
    private String tertiaryHeading;

    /**
     * 解决方案简介
     */
    @Column(name = "SOLUTION_SYNOPSIS")
    private String solutionSynopsis;

    /**
     * 解决方案图片
     */
    @Column(name = "SOLUTION_PIC")
    private String solutionPic;

    /**
     * 解决方案分类（外键）
     */
    @Column(name = "SOLUTION_CLASS")
    private String solutionClass;

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
     * 解决方案正文
     */
    @Column(name = "SOLUTION_TEXT")
    private String solutionText;

    /**
     * 获取解决方案id
     *
     * @return ID - 解决方案id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置解决方案id
     *
     * @param id 解决方案id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取一级标题
     *
     * @return FIRST_HEADING - 一级标题
     */
    public String getFirstHeading() {
        return firstHeading;
    }

    /**
     * 设置一级标题
     *
     * @param firstHeading 一级标题
     */
    public void setFirstHeading(String firstHeading) {
        this.firstHeading = firstHeading;
    }

    /**
     * 获取二级标题
     *
     * @return SECONDARY_HEADING - 二级标题
     */
    public String getSecondaryHeading() {
        return secondaryHeading;
    }

    /**
     * 设置二级标题
     *
     * @param secondaryHeading 二级标题
     */
    public void setSecondaryHeading(String secondaryHeading) {
        this.secondaryHeading = secondaryHeading;
    }

    /**
     * 获取三级标题
     *
     * @return TERTIARY_HEADING - 三级标题
     */
    public String getTertiaryHeading() {
        return tertiaryHeading;
    }

    /**
     * 设置三级标题
     *
     * @param tertiaryHeading 三级标题
     */
    public void setTertiaryHeading(String tertiaryHeading) {
        this.tertiaryHeading = tertiaryHeading;
    }

    /**
     * 获取解决方案简介
     *
     * @return SOLUTION_SYNOPSIS - 解决方案简介
     */
    public String getSolutionSynopsis() {
        return solutionSynopsis;
    }

    /**
     * 设置解决方案简介
     *
     * @param solutionSynopsis 解决方案简介
     */
    public void setSolutionSynopsis(String solutionSynopsis) {
        this.solutionSynopsis = solutionSynopsis;
    }

    /**
     * 获取解决方案图片
     *
     * @return SOLUTION_PIC - 解决方案图片
     */
    public String getSolutionPic() {
        return solutionPic;
    }

    /**
     * 设置解决方案图片
     *
     * @param solutionPic 解决方案图片
     */
    public void setSolutionPic(String solutionPic) {
        this.solutionPic = solutionPic;
    }

    /**
     * 获取解决方案分类（外键）
     *
     * @return SOLUTION_CLASS - 解决方案分类（外键）
     */
    public String getSolutionClass() {
        return solutionClass;
    }

    /**
     * 设置解决方案分类（外键）
     *
     * @param solutionClass 解决方案分类（外键）
     */
    public void setSolutionClass(String solutionClass) {
        this.solutionClass = solutionClass;
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

    /**
     * 获取解决方案正文
     *
     * @return SOLUTION_TEXT - 解决方案正文
     */
    public String getSolutionText() {
        return solutionText;
    }

    /**
     * 设置解决方案正文
     *
     * @param solutionText 解决方案正文
     */
    public void setSolutionText(String solutionText) {
        this.solutionText = solutionText;
    }
}