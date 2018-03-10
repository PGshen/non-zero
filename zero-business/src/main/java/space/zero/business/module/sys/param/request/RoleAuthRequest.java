package space.zero.business.module.sys.param.request;

import java.util.List;

/**
 * Created by PG_shen
 * Date : 3/8/18
 * Time : 4:15 PM
 * 角色授权请求参数
 */
public class RoleAuthRequest {
    private String id;

    private List<String> menus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getMenus() {
        return menus;
    }

    public void setMenus(List<String> menus) {
        this.menus = menus;
    }
}
