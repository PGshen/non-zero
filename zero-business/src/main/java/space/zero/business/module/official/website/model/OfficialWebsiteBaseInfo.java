package space.zero.business.module.official.website.model;

import space.zero.business.module.official.website.base.WebsiteEntity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "official_website_base_info")
public class OfficialWebsiteBaseInfo extends WebsiteEntity {
    /**
     * 基础信息id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 网站名称
     */
    @Column(name = "SITE_NAME")
    private String siteName;

    /**
     * logo路径
     */
    @Column(name = "LOGO_URL")
    private String logoUrl;

    /**
     * 首页关键字
     */
    @Column(name = "KEY_WORDS")
    private String keyWords;

    /**
     * 联系方式
     */
    @Column(name = "CONTACT")
    private String contact;

    /**
     * 备案信息
     */
    @Column(name = "RECORD")
    private String record;

    /**
     * 版权信息
     */
    @Column(name = "COPYRIGHT")
    private String copyright;

    /**
     * 二维码路径
     */
    @Column(name = "QR_CODE_URL")
    private String qrCodeUrl;

    /**
     * 首页描述
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
     * 获取基础信息id
     *
     * @return ID - 基础信息id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置基础信息id
     *
     * @param id 基础信息id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取网站名称
     *
     * @return SITE_NAME - 网站名称
     */
    public String getSiteName() {
        return siteName;
    }

    /**
     * 设置网站名称
     *
     * @param siteName 网站名称
     */
    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    /**
     * 获取logo路径
     *
     * @return LOGO_URL - logo路径
     */
    public String getLogoUrl() {
        return logoUrl;
    }

    /**
     * 设置logo路径
     *
     * @param logoUrl logo路径
     */
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    /**
     * 获取首页关键字
     *
     * @return KEY_WORDS - 首页关键字
     */
    public String getKeyWords() {
        return keyWords;
    }

    /**
     * 设置首页关键字
     *
     * @param keyWords 首页关键字
     */
    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    /**
     * 获取联系方式
     *
     * @return CONTACT - 联系方式
     */
    public String getContact() {
        return contact;
    }

    /**
     * 设置联系方式
     *
     * @param contact 联系方式
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * 获取备案信息
     *
     * @return RECORD - 备案信息
     */
    public String getRecord() {
        return record;
    }

    /**
     * 设置备案信息
     *
     * @param record 备案信息
     */
    public void setRecord(String record) {
        this.record = record;
    }

    /**
     * 获取版权信息
     *
     * @return COPYRIGHT - 版权信息
     */
    public String getCopyright() {
        return copyright;
    }

    /**
     * 设置版权信息
     *
     * @param copyright 版权信息
     */
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    /**
     * 获取二维码路径
     *
     * @return QR_CODE_URL - 二维码路径
     */
    public String getQrCodeUrl() {
        return qrCodeUrl;
    }

    /**
     * 设置二维码路径
     *
     * @param qrCodeUrl 二维码路径
     */
    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }

    /**
     * 获取首页描述
     *
     * @return DESCRIPTION - 首页描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置首页描述
     *
     * @param description 首页描述
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