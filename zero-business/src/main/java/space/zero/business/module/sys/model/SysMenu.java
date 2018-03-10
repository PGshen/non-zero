package space.zero.business.module.sys.model;

import space.zero.core.model.BaseEntity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_menu")
public class SysMenu extends BaseEntity {
    /**
     * 菜单id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 父菜单ID，一级菜单为0
     */
    @Column(name = "PARENT_ID")
    private String parentId;

    /**
     * 名称
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 别名
     */
    @Column(name = "DISPLAY_NAME")
    private String displayName;

    /**
     * 图标对应的class
     */
    @Column(name = "ICON_CLASS")
    private String iconClass;

    /**
     * 图标的url
     */
    @Column(name = "ICON_URL")
    private String iconUrl;

    /**
     * 菜单需要的权限，多个权限采用，分割（sys:user:list,sys:user:save）
     */
    @Column(name = "PERMS")
    private String perms;

    /**
     * 菜单类型（0：目录   1：菜单   2：按钮或其他可点击的元素）
     */
    @Column(name = "TYPE")
    private Integer type;

    /**
     * 菜单排序
     */
    @Column(name = "ORDER_NUM")
    private Integer orderNum;

    /**
     * 是否删除(1:删除  0:未删除)
     */
    @Column(name = "IS_DELETE")
    private transient String isDelete;

    /**
     * 是否显示(1:显示  0:不显示)
     */
    @Column(name = "IS_SHOW")
    private transient String isShow;

    /**
     * 是否启用(1:启用  0:不启用)
     */
    @Column(name = "IS_ENABLE")
    private transient String isEnable;

    @Column(name = "CREATED_TIME")
    private Date createdTime;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    /**
     * 菜单URL
     */
    @Column(name = "URL")
    private String url;

    /**
     * 获取菜单id
     *
     * @return ID - 菜单id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置菜单id
     *
     * @param id 菜单id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取父菜单ID，一级菜单为0
     *
     * @return PARENT_ID - 父菜单ID，一级菜单为0
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置父菜单ID，一级菜单为0
     *
     * @param parentId 父菜单ID，一级菜单为0
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取名称
     *
     * @return NAME - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取别名
     *
     * @return DISPLAY_NAME - 别名
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * 设置别名
     *
     * @param displayName 别名
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * 获取图标对应的class
     *
     * @return ICON_CLASS - 图标对应的class
     */
    public String getIconClass() {
        return iconClass;
    }

    /**
     * 设置图标对应的class
     *
     * @param iconClass 图标对应的class
     */
    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    /**
     * 获取图标的url
     *
     * @return ICON_URL - 图标的url
     */
    public String getIconUrl() {
        return iconUrl;
    }

    /**
     * 设置图标的url
     *
     * @param iconUrl 图标的url
     */
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    /**
     * 获取菜单需要的权限，多个权限采用，分割（sys:user:list,sys:user:save）
     *
     * @return PERMS - 菜单需要的权限，多个权限采用，分割（sys:user:list,sys:user:save）
     */
    public String getPerms() {
        return perms;
    }

    /**
     * 设置菜单需要的权限，多个权限采用，分割（sys:user:list,sys:user:save）
     *
     * @param perms 菜单需要的权限，多个权限采用，分割（sys:user:list,sys:user:save）
     */
    public void setPerms(String perms) {
        this.perms = perms;
    }

    /**
     * 获取菜单类型（0：目录   1：菜单   2：按钮或其他可点击的元素）
     *
     * @return TYPE - 菜单类型（0：目录   1：菜单   2：按钮或其他可点击的元素）
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置菜单类型（0：目录   1：菜单   2：按钮或其他可点击的元素）
     *
     * @param type 菜单类型（0：目录   1：菜单   2：按钮或其他可点击的元素）
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取菜单排序
     *
     * @return ORDER_NUM - 菜单排序
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * 设置菜单排序
     *
     * @param orderNum 菜单排序
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
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
     * 获取是否显示(1:显示  0:不显示)
     *
     * @return IS_SHOW - 是否显示(1:显示  0:不显示)
     */
    public String getIsShow() {
        return isShow;
    }

    /**
     * 设置是否显示(1:显示  0:不显示)
     *
     * @param isShow 是否显示(1:显示  0:不显示)
     */
    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    /**
     * 获取是否启用(1:启用  0:不启用)
     *
     * @return IS_ENABLE - 是否启用(1:启用  0:不启用)
     */
    public String getIsEnable() {
        return isEnable;
    }

    /**
     * 设置是否启用(1:启用  0:不启用)
     *
     * @param isEnable 是否启用(1:启用  0:不启用)
     */
    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }

    /**
     * @return CREATED_TIME
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * @param createdTime
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * @return UPDATE_TIME
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取菜单URL
     *
     * @return URL - 菜单URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置菜单URL
     *
     * @param url 菜单URL
     */
    public void setUrl(String url) {
        this.url = url;
    }
}