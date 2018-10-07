package space.zero.business.module.official.website.model;

import space.zero.business.module.official.website.base.WebsiteEntity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "official_website_news")
public class OfficialWebsiteNews extends WebsiteEntity {
    /**
     * 新闻id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 新闻标题
     */
    @Column(name = "TITLE")
    private String title;

    /**
     * 小图路径
     */
    @Column(name = "TITLE_PIC")
    private String titlePic;

    /**
     * 摘要
     */
    @Column(name = "SYNOPSIS")
    private String synopsis;

    /**
     * 发布时间
     */
    @Column(name = "RELEASE_TIME")
    private Date releaseTime;

    /**
     * 阅读次数
     */
    @Column(name = "READING_TIMES")
    private Integer readingTimes;

    /**
     * 分类（外键）
     */
    @Column(name = "NEWS_CLASS")
    private String newsClass;

    /**
     * 标签
     */
    @Column(name = "TAGS")
    private String tags;

    /**
     * 作者
     */
    @Column(name = "AUTHOR")
    private String author;

    /**
     * 作者
     */
    @Column(name = "STATUS")
    private String status;

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
     * 正文
     */
    @Column(name = "CONTENT")
    private String content;

    /**
     * 获取新闻id
     *
     * @return ID - 新闻id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置新闻id
     *
     * @param id 新闻id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取新闻标题
     *
     * @return TITLE - 新闻标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置新闻标题
     *
     * @param title 新闻标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取小图路径
     *
     * @return TITLE_PIC - 小图路径
     */
    public String getTitlePic() {
        return titlePic;
    }

    /**
     * 设置小图路径
     *
     * @param titlePic 小图路径
     */
    public void setTitlePic(String titlePic) {
        this.titlePic = titlePic;
    }

    /**
     * 获取摘要
     *
     * @return SYNOPSIS - 摘要
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     * 设置摘要
     *
     * @param synopsis 摘要
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    /**
     * 获取发布时间
     *
     * @return RELEASE_TIME - 发布时间
     */
    public Date getReleaseTime() {
        return releaseTime;
    }

    /**
     * 设置发布时间
     *
     * @param releaseTime 发布时间
     */
    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    /**
     * 获取阅读次数
     *
     * @return READING_TIMES - 阅读次数
     */
    public Integer getReadingTimes() {
        return readingTimes;
    }

    /**
     * 设置阅读次数
     *
     * @param readingTimes 阅读次数
     */
    public void setReadingTimes(Integer readingTimes) {
        this.readingTimes = readingTimes;
    }

    /**
     * 获取分类（外键）
     *
     * @return NEWS_CLASS - 分类（外键）
     */
    public String getNewsClass() {
        return newsClass;
    }

    /**
     * 设置分类（外键）
     *
     * @param newsClass 分类（外键）
     */
    public void setNewsClass(String newsClass) {
        this.newsClass = newsClass;
    }

    /**
     * 获取标签
     *
     * @return TAGS - 标签
     */
    public String getTags() {
        return tags;
    }

    /**
     * 设置标签
     *
     * @param tags 标签
     */
    public void setTags(String tags) {
        this.tags = tags;
    }

    /**
     * 获取作者
     *
     * @return AUTHOR - 作者
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置作者
     *
     * @param author 作者
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取新闻状态
     * @return STATUS 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置新闻状态
     * @param status 0:草稿 1:已发布 2:已删除
     */
    public void setStatus(String status) {
        this.status = status;
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
     * 获取正文
     *
     * @return CONTENT - 正文
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置正文
     *
     * @param content 正文
     */
    public void setContent(String content) {
        this.content = content;
    }
}