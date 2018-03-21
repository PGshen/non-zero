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
     * 图标的url
     */
    @Column(name = "ICON")
    private String icon;

    /**
     * 菜单授权标识（格式如sys:user:list,sys:user:save）
     */
    @Column(name = "PERM")
    private String perm;

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
    private String isDelete;

    /**
     * 是否启用(1:启用  0:不启用)
     */
    @Column(name = "IS_ENABLE")
    private String isEnable;

    @Column(name = "CREATED_TIME")
    private Date createdTime;

    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    /**
     * 是否隐藏菜单(1:隐藏 0:不隐藏)
     */
    @Column(name = "HIDDEN")
    private String hidden;

    /**
     * 是否作为子菜单显示(1:是 0:否)
     */
    @Column(name = "ALWAYS_SHOW")
    private String alwaysShow;

    /**
     * 组件路径
     */
    @Column(name = "COMPONENT")
    private String component;

    /**
     * 是否重定向路径,默认'noredirect'
     */
    @Column(name = "REDIRECT")
    private String redirect;

    /**
     * 创建者
     */
    @Column(name = "CREATE_USER")
    private String createUser;

    /**
     * 菜单的显示名称
     */
    @Column(name = "TITLE")
    private String title;

    /**
     * 请求的method
     */
    @Column(name = "METHOD")
    private String method;

    /**
     * 菜单path
     */
    @Column(name = "PATH")
    private String path;

    /**
     * 请求后端的URL
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
     * 获取图标的url
     *
     * @return ICON - 图标的url
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置图标的url
     *
     * @param icon 图标的url
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取菜单授权标识（格式如sys:user:list,sys:user:save）
     *
     * @return PERM - 菜单授权标识（格式如sys:user:list,sys:user:save）
     */
    public String getPerm() {
        return perm;
    }

    /**
     * 设置菜单授权标识（格式如sys:user:list,sys:user:save）
     *
     * @param perm 菜单授权标识（格式如sys:user:list,sys:user:save）
     */
    public void setPerm(String perm) {
        this.perm = perm;
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
     * 获取是否隐藏菜单(1:隐藏 0:不隐藏)
     *
     * @return HIDDEN - 是否隐藏菜单(1:隐藏 0:不隐藏)
     */
    public String getHidden() {
        return hidden;
    }

    /**
     * 设置是否隐藏菜单(1:隐藏 0:不隐藏)
     *
     * @param hidden 是否隐藏菜单(1:隐藏 0:不隐藏)
     */
    public void setHidden(String hidden) {
        this.hidden = hidden;
    }

    /**
     * 获取是否作为子菜单显示(1:是 0:否)
     *
     * @return ALWAYS_SHOW - 是否作为子菜单显示(1:是 0:否)
     */
    public String getAlwaysShow() {
        return alwaysShow;
    }

    /**
     * 设置是否作为子菜单显示(1:是 0:否)
     *
     * @param alwaysShow 是否作为子菜单显示(1:是 0:否)
     */
    public void setAlwaysShow(String alwaysShow) {
        this.alwaysShow = alwaysShow;
    }

    /**
     * 获取组件路径
     *
     * @return COMPONENT - 组件路径
     */
    public String getComponent() {
        return component;
    }

    /**
     * 设置组件路径
     *
     * @param component 组件路径
     */
    public void setComponent(String component) {
        this.component = component;
    }

    /**
     * 获取是否重定向路径,默认'noredirect'
     *
     * @return REDIRECT - 是否重定向路径,默认'noredirect'
     */
    public String getRedirect() {
        return redirect;
    }

    /**
     * 设置是否重定向路径,默认'noredirect'
     *
     * @param redirect 是否重定向路径,默认'noredirect'
     */
    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    /**
     * 获取创建者
     *
     * @return CREATE_USER - 创建者
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 设置创建者
     *
     * @param createUser 创建者
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * 获取菜单的显示名称
     *
     * @return TITLE - 菜单的显示名称
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置菜单的显示名称
     *
     * @param title 菜单的显示名称
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取请求的method
     *
     * @return METHOD - 请求的method
     */
    public String getMethod() {
        return method;
    }

    /**
     * 设置请求的method
     *
     * @param method 请求的method
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * 获取菜单path
     *
     * @return PATH - 菜单path
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置菜单path
     *
     * @param path 菜单path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取请求后端的URL
     *
     * @return URL - 请求后端的URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置请求后端的URL
     *
     * @param url 请求后端的URL
     */
    public void setUrl(String url) {
        this.url = url;
    }
}