package space.zero.business.module.official.website.param.request;

import java.util.Map;

/**
 * Created by IntelliJ IDEA
 * User: pipix
 * Date: 10/3/18
 * TIME: 10:59 PM
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
