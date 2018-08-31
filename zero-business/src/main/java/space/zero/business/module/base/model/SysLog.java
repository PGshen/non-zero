package space.zero.business.module.base.model;

import space.zero.core.model.BaseEntity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_log")
public class SysLog extends BaseEntity {
    /**
     * 日志id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 请求IP
     */
    @Column(name = "CLIENT_IP")
    private String clientIp;

    /**
     * 请求路径
     */
    @Column(name = "URI")
    private String uri;

    /**
     * 请求方式（普通/ajax）
     */
    @Column(name = "TYPE")
    private String type;

    /**
     * 请求方式（post/get/put/delete)
     */
    @Column(name = "METHOD")
    private String method;

    /**
     * 请求参数（json格式)
     */
    @Column(name = "PARAM_DATA")
    private String paramData;

    /**
     * session id
     */
    @Column(name = "SESSION_ID")
    private String sessionId;

    /**
     * 请求时间
     */
    @Column(name = "TIME")
    private String time;

    /**
     * 接口返回时间
     */
    @Column(name = "RETURN_TIME")
    private String returnTime;

    /**
     * 是否启用
     */
    @Column(name = "IS_ENABLE")
    private String isEnable;

    /**
     * 创建时间
     */
    @Column(name = "CREATED_TIME")
    private Date createdTime;

    /**
     * 更新时间
     */
    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    /**
     * 是否删除(1:删除  0:未删除)
     */
    @Column(name = "IS_DELETE")
    private String isDelete;

    /**
     * 时间差
     */
    @Column(name = "TIME_CONSUMING")
    private String timeConsuming;

    /**
     * 响应状态码
     */
    @Column(name = "STATUS_CODE")
    private String statusCode;

    /**
     * 获取日志id
     *
     * @return ID - 日志id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置日志id
     *
     * @param id 日志id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取请求IP
     *
     * @return CLIENT_IP - 请求IP
     */
    public String getClientIp() {
        return clientIp;
    }

    /**
     * 设置请求IP
     *
     * @param clientIp 请求IP
     */
    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    /**
     * 获取请求路径
     *
     * @return URI - 请求路径
     */
    public String getUri() {
        return uri;
    }

    /**
     * 设置请求路径
     *
     * @param uri 请求路径
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     * 获取请求方式（普通/ajax）
     *
     * @return TYPE - 请求方式（普通/ajax）
     */
    public String getType() {
        return type;
    }

    /**
     * 设置请求方式（普通/ajax）
     *
     * @param type 请求方式（普通/ajax）
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取请求方式（post/get/put/delete)
     *
     * @return METHOD - 请求方式（post/get/put/delete)
     */
    public String getMethod() {
        return method;
    }

    /**
     * 设置请求方式（post/get/put/delete)
     *
     * @param method 请求方式（post/get/put/delete)
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * 获取请求参数（json格式)
     *
     * @return PARAM_DATA - 请求参数（json格式)
     */
    public String getParamData() {
        return paramData;
    }

    /**
     * 设置请求参数（json格式)
     *
     * @param paramData 请求参数（json格式)
     */
    public void setParamData(String paramData) {
        this.paramData = paramData;
    }

    /**
     * 获取session id
     *
     * @return SESSION_ID - session id
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * 设置session id
     *
     * @param sessionId session id
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * 获取请求时间
     *
     * @return TIME - 请求时间
     */
    public String getTime() {
        return time;
    }

    /**
     * 设置请求时间
     *
     * @param time 请求时间
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 获取接口返回时间
     *
     * @return RETURN_TIME - 接口返回时间
     */
    public String getReturnTime() {
        return returnTime;
    }

    /**
     * 设置接口返回时间
     *
     * @param returnTime 接口返回时间
     */
    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    /**
     * 获取是否启用
     *
     * @return IS_ENABLE - 是否启用
     */
    public String getIsEnable() {
        return isEnable;
    }

    /**
     * 设置是否启用
     *
     * @param isEnable 是否启用
     */
    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }

    /**
     * 获取创建时间
     *
     * @return CREATED_TIME - 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置创建时间
     *
     * @param createdTime 创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取更新时间
     *
     * @return UPDATE_TIME - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
     * 获取时间差
     *
     * @return TIME_CONSUMING - 时间差
     */
    public String getTimeConsuming() {
        return timeConsuming;
    }

    /**
     * 设置时间差
     *
     * @param timeConsuming 时间差
     */
    public void setTimeConsuming(String timeConsuming) {
        this.timeConsuming = timeConsuming;
    }

    /**
     * 获取响应状态码
     *
     * @return STATUS_CODE - 响应状态码
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * 设置响应状态码
     *
     * @param statusCode 响应状态码
     */
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}