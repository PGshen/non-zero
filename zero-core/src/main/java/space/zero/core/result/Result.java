package space.zero.core.result;

import com.alibaba.fastjson.JSON;


/**
 * 统一API响应结果封装
 */
public class Result {
    private int status;
    private int code;
    private String message;
    private Object data;
    private Long timestamp;

//    public Result(){}

//    public Result(){
//        this.timestamp = new Date().getTime();
//    }

    public Result setCode(ResultCode resultCode) {
        this.code = resultCode.code();
        return this;
    }

    public int getStatus() {
        return status;
    }

    public Result setStatus(int status) {
        this.status = status;
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public Result setData(Object data) {
        this.data = data;
        return this;
    }

    public Long getTimestamp(){
        return timestamp;
    }

    public Result setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}

