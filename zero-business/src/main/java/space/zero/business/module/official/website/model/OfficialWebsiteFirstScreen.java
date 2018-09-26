package space.zero.business.module.official.website.model;

import space.zero.core.model.BaseEntity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "official_website_first_screen")
public class OfficialWebsiteFirstScreen extends BaseEntity {
    /**
     * 首屏id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 图片
     */
    @Column(name = "PIC")
    private String pic;

    /**
     * 标题
     */
    @Column(name = "HEADING")
    private String heading;

    /**
     * 副标题
     */
    @Column(name = "SUB_HEADING")
    private String subHeading;

    /**
     * 描述
     */
    @Column(name = "DESCRIPTION")
    private String description;

    /**
     * 首屏类别（外键）
     */
    @Column(name = "FIRST_SCREEN_CLASS")
    private String firstScreenClass;

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
     * 获取首屏id
     *
     * @return ID - 首屏id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置首屏id
     *
     * @param id 首屏id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取图片
     *
     * @return PIC - 图片
     */
    public String getPic() {
        return pic;
    }

    /**
     * 设置图片
     *
     * @param pic 图片
     */
    public void setPic(String pic) {
        this.pic = pic;
    }

    /**
     * 获取标题
     *
     * @return HEADING - 标题
     */
    public String getHeading() {
        return heading;
    }

    /**
     * 设置标题
     *
     * @param heading 标题
     */
    public void setHeading(String heading) {
        this.heading = heading;
    }

    /**
     * 获取副标题
     *
     * @return SUB_HEADING - 副标题
     */
    public String getSubHeading() {
        return subHeading;
    }

    /**
     * 设置副标题
     *
     * @param subHeading 副标题
     */
    public void setSubHeading(String subHeading) {
        this.subHeading = subHeading;
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
     * 获取首屏类别（外键）
     *
     * @return FIRST_SCREEN_CLASS - 首屏类别（外键）
     */
    public String getFirstScreenClass() {
        return firstScreenClass;
    }

    /**
     * 设置首屏类别（外键）
     *
     * @param firstScreenClass 首屏类别（外键）
     */
    public void setFirstScreenClass(String firstScreenClass) {
        this.firstScreenClass = firstScreenClass;
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