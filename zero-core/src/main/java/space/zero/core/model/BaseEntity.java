package space.zero.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

public class BaseEntity implements Serializable {
    public static final long serialVersionUID = 1L;
    @Transient
    @JsonIgnore
    protected transient  String isDelete;
    @Transient
    @JsonIgnore
    protected transient  String isEnable;
    @Transient
    @JsonIgnore
    protected transient  Date updateTime;

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
