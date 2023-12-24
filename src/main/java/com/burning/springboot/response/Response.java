package com.burning.springboot.response;

import com.burning.springboot.common.enums.ResponseStatus;
import lombok.Data;

import java.io.Serializable;

/**
 * 统一web请求响应类
 * @author 会游泳的蚂蚁
 * @date 2023/12/20 12:11
 */
@Data
public class Response<T> implements Serializable {
    private int code;
    private String message;
    private T data;

    public Response() {

    }

    public Response(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Response<T> buildSuccess() {
        return build(ResponseStatus.SUCCESS.getCode(), ResponseStatus.SUCCESS.getDesc(), null);
    }

    public static <T> Response<T> buildSuccess(ResponseStatus responseStatus) {
        return build(responseStatus.getCode(), responseStatus.getDesc(), null);
    }

    public static <T> Response<T> buildSuccess(ResponseStatus responseStatus, T data) {
        return build(responseStatus.getCode(), responseStatus.getDesc(), data);
    }

    public static <T> Response<T> buildSuccess(ResponseStatus responseStatus, String message, T data) {
        return build(responseStatus.getCode(), message, data);
    }


    public static <T> Response<T> buildFailed() {
        return build(ResponseStatus.Fail.getCode(), ResponseStatus.Fail.getDesc(), null);
    }

    public static <T> Response<T> buildFailed(ResponseStatus responseStatus) {
        return build(responseStatus.getCode(), responseStatus.getDesc(), null);
    }

    public static <T> Response<T> buildFailed(ResponseStatus responseStatus, T data) {
        return build(responseStatus.getCode(), responseStatus.getDesc(), data);
    }

    public static <T> Response<T> buildFailed(ResponseStatus responseStatus, String message, T data) {
        return build(responseStatus.getCode(), message, data);
    }

    public static <T> Response<T> buildFailed(Integer code, String message) {
        return build(code, message, null);
    }

    public static <T> Response<T> build(int code, String message, T data) {
        Response<T> response = new Response<>();
        response.code = code;
        response.message = message;
        response.data = data;
        return response;
    }
}
