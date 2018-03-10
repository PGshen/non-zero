package space.zero.core.result;

import java.util.Date;

/**
 * 响应结果生成工具
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result genSuccessResult() {
        return new Result()
                .setStatus(1)
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setTimestamp(new Date().getTime());
    }

    public static Result genSuccessResult(Object data) {
        return new Result()
                .setStatus(1)
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data)
                .setTimestamp(new Date().getTime());
    }

    public static Result genSuccessResult(String message) {
        return new Result()
                .setStatus(1)
                .setCode(ResultCode.SUCCESS)
                .setMessage(message)
                .setTimestamp(new Date().getTime());
    }

    public static Result genSuccessResult(Object data, String message){
        return new Result()
                .setStatus(1)
                .setCode(ResultCode.SUCCESS)
                .setMessage(message)
                .setData(data)
                .setTimestamp(new Date().getTime());
    }

    public static Result genFailResult(String message) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(message)
                .setTimestamp(new Date().getTime());
    }

    public static Result genForbiddenResult(Object data, String message){
        return new Result()
                .setCode(ResultCode.FORBIDDEN)
                .setData(data)
                .setMessage(message)
                .setTimestamp(new Date().getTime());
    }
}

