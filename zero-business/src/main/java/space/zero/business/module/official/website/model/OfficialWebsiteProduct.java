package space.zero.business.module.official.website.model;

import space.zero.core.model.BaseEntity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "official_website_product")
public class OfficialWebsiteProduct extends BaseEntity {
    /**
     * 产品id
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
     * 产品简介
     */
    @Column(name = "PRODUCT_SYNOPSIS")
    private String productSynopsis;

    /**
     * 产品图片
     */
    @Column(name = "PRODUCT_PIC")
    private String productPic;

    /**
     * 产品分类（外键）
     */
    @Column(name = "PRODUCT_CLASS")
    private String productClass;

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
     * 产品正文
     */
    @Column(name = "PRODUCT_TEXT")
    private String productText;

    /**
     * 获取产品id
     *
     * @return ID - 产品id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置产品id
     *
     * @param id 产品id
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
     * 获取产品简介
     *
     * @return PRODUCT_SYNOPSIS - 产品简介
     */
    public String getProductSynopsis() {
        return productSynopsis;
    }

    /**
     * 设置产品简介
     *
     * @param productSynopsis 产品简介
     */
    public void setProductSynopsis(String productSynopsis) {
        this.productSynopsis = productSynopsis;
    }

    /**
     * 获取产品图片
     *
     * @return PRODUCT_PIC - 产品图片
     */
    public String getProductPic() {
        return productPic;
    }

    /**
     * 设置产品图片
     *
     * @param productPic 产品图片
     */
    public void setProductPic(String productPic) {
        this.productPic = productPic;
    }

    /**
     * 获取产品分类（外键）
     *
     * @return PRODUCT_CLASS - 产品分类（外键）
     */
    public String getProductClass() {
        return productClass;
    }

    /**
     * 设置产品分类（外键）
     *
     * @param productClass 产品分类（外键）
     */
    public void setProductClass(String productClass) {
        this.productClass = productClass;
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
     * 获取产品正文
     *
     * @return PRODUCT_TEXT - 产品正文
     */
    public String getProductText() {
        return productText;
    }

    /**
     * 设置产品正文
     *
     * @param productText 产品正文
     */
    public void setProductText(String productText) {
        this.productText = productText;
    }
}