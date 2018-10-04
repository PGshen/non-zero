package space.zero.business.module.official.website.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.codehaus.jackson.map.Serializers;
import space.zero.core.model.BaseEntity;

import javax.persistence.Transient;
import java.util.Date;

/**
 * Created by IntelliJ IDEA
 * User: pipix
 * Date: 10/4/18
 * TIME: 4:32 PM
 */
public class WebsiteEntity extends BaseEntity {
    @Transient
    @JsonIgnore
    private String id;
    @Transient
    @JsonIgnore
    private Date createdTime;
    @Transient
    @JsonIgnore
    private String updateUser;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
}
