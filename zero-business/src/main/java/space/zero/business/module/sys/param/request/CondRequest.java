package space.zero.business.module.sys.param.request;

import space.zero.core.model.BaseEntity;

import java.util.Map;

/**
 * Created by PG_shen
 * Date : 3/14/18
 * Time : 9:59 AM
 */
public class CondRequest<T> {
    //页码
    private Integer page;
    //页大小
    private Integer size;
    //排序字段
    private String order;
    private Map<String, Object> cond;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Map<String, Object> getCond() {
        return cond;
    }

    public void setCond(Map<String, Object> cond) {
        this.cond = cond;
    }
}
