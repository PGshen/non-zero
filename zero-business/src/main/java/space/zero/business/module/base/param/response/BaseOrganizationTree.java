package space.zero.business.module.base.param.response;

import java.util.List;

/**
 * Created by PG_shen
 * Date : 3/17/18
 * Time : 5:09 PM
 */
public class BaseOrganizationTree {

    private String id;

    private String parentId;

    private String name;

    private String email;

    private String remark;

    private String postCode;

    private String type;

    private String tel;

    private String description;

    private List<BaseOrganizationTree> children;

    public BaseOrganizationTree(){}

    public BaseOrganizationTree(String id, String parentId, String name, String email, String remark, String postCode, String type, String tel, String description) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.email = email;
        this.remark = remark;
        this.postCode = postCode;
        this.type = type;
        this.tel = tel;
        this.description = description;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<BaseOrganizationTree> getChildren() {
        return children;
    }

    public void setChildren(List<BaseOrganizationTree> children) {
        this.children = children;
    }
}
