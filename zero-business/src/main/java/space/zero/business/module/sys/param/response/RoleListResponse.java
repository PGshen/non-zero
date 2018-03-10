package space.zero.business.module.sys.param.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by PG_shen
 * Date : 3/8/18
 * Time : 2:29 PM
 */
public class RoleListResponse implements Serializable{
    @JsonProperty("value")
    private String id;

    @JsonProperty("label")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
