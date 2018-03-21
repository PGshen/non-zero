package space.zero.business.module.sys.param.response;

import java.io.Serializable;
import java.util.List;

/**
 * Created by PG_shen
 * Date : 3/8/18
 * Time : 2:37 PM
 */
public class SysMenuTree implements Serializable{
    private String id;

    private String parentId;

    private String name;

    private String title;

    private String icon;
    
    private String path;

    private String perm;

    private Integer type;

    private Integer orderNum;

    private String hidden;

    private String alwaysShow;
    
    private String component;
    
    private String redirect;

    private String url;

    private String method;

    private List<SysMenuTree> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPerm() {
        return perm;
    }

    public void setPerm(String perm) {
        this.perm = perm;
    }

    public String getHidden() {
        return hidden;
    }

    public void setHidden(String hidden) {
        this.hidden = hidden;
    }

    public String getAlwaysShow() {
        return alwaysShow;
    }

    public void setAlwaysShow(String alwaysShow) {
        this.alwaysShow = alwaysShow;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public List<SysMenuTree> getChildren() {
        return children;
    }

    public void setChildren(List<SysMenuTree> children) {
        this.children = children;
    }
}
