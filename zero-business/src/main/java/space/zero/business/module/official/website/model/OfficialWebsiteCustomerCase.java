package space.zero.business.module.official.website.model;

import space.zero.business.module.official.website.base.WebsiteEntity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "official_website_customer_case")
public class OfficialWebsiteCustomerCase extends WebsiteEntity {
    /**
     * 客户案例id
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
     * 客户案例简介
     */
    @Column(name = "CUSTOMER_CASE_SYNOPSIS")
    private String customerCaseSynopsis;

    /**
     * 客户案例图片
     */
    @Column(name = "CASE_PIC")
    private String casePic;

    /**
     * 客户案例分类（外键）
     */
    @Column(name = "CASE_CLASS")
    private String caseClass;

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
     * 客户案例正文
     */
    @Column(name = "CASE_TEXT")
    private String caseText;

    /**
     * 获取客户案例id
     *
     * @return ID - 客户案例id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置客户案例id
     *
     * @param id 客户案例id
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
     * 获取客户案例简介
     *
     * @return CUSTOMER_CASE_SYNOPSIS - 客户案例简介
     */
    public String getCustomerCaseSynopsis() {
        return customerCaseSynopsis;
    }

    /**
     * 设置客户案例简介
     *
     * @param customerCaseSynopsis 客户案例简介
     */
    public void setCustomerCaseSynopsis(String customerCaseSynopsis) {
        this.customerCaseSynopsis = customerCaseSynopsis;
    }

    /**
     * 获取客户案例图片
     *
     * @return CASE_PIC - 客户案例图片
     */
    public String getCasePic() {
        return casePic;
    }

    /**
     * 设置客户案例图片
     *
     * @param casePic 客户案例图片
     */
    public void setCasePic(String casePic) {
        this.casePic = casePic;
    }

    /**
     * 获取客户案例分类（外键）
     *
     * @return CASE_CLASS - 客户案例分类（外键）
     */
    public String getCaseClass() {
        return caseClass;
    }

    /**
     * 设置客户案例分类（外键）
     *
     * @param caseClass 客户案例分类（外键）
     */
    public void setCaseClass(String caseClass) {
        this.caseClass = caseClass;
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
     * 获取客户案例正文
     *
     * @return CASE_TEXT - 客户案例正文
     */
    public String getCaseText() {
        return caseText;
    }

    /**
     * 设置客户案例正文
     *
     * @param caseText 客户案例正文
     */
    public void setCaseText(String caseText) {
        this.caseText = caseText;
    }
}