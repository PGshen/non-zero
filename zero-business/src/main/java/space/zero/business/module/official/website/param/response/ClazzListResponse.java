package space.zero.business.module.official.website.param.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA
 * User: pipix
 * Date: 10/5/18
 * TIME: 1:03 AM
 */
public class ClazzListResponse implements Serializable {
    @JsonProperty("value")
    private String id;

    @JsonProperty("label")
    private String clazzValue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClazzValue() {
        return clazzValue;
    }

    public void setClazzValue(String clazzValue) {
        this.clazzValue = clazzValue;
    }
}
