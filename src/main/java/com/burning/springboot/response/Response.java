package com.burning.springboot.response;

import com.burning.springboot.common.enums.ResponseStatus;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 会游泳的蚂蚁
 * @description:
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

    public static <E> Response<E> buildSuccess() {
        return build(ResponseStatus.SUCCESS.getCode(), ResponseStatus.SUCCESS.getDesc(), null);
    }

    public static <E> Response<E> buildSuccess(ResponseStatus responseStatus) {
        return build(responseStatus.getCode(), responseStatus.getDesc(), null);
    }

    public static <E> Response<E> buildSuccess(ResponseStatus responseStatus, E data) {
        return build(responseStatus.getCode(), responseStatus.getDesc(), data);
    }

    public static <E> Response<E> buildSuccess(ResponseStatus responseStatus, String message, E data) {
        return build(responseStatus.getCode(), message, data);
    }


    public static <E> Response<E> buildFailed() {
        return build(ResponseStatus.Fail.getCode(), ResponseStatus.Fail.getDesc(), null);
    }

    public static <E> Response<E> buildFailed(ResponseStatus responseStatus) {
        return build(responseStatus.getCode(), responseStatus.getDesc(), null);
    }

    public static <E> Response<E> buildFailed(ResponseStatus responseStatus, E data) {
        return build(responseStatus.getCode(), responseStatus.getDesc(), data);
    }

    public static <E> Response<E> buildFailed(ResponseStatus responseStatus, String message, E data) {
        return build(responseStatus.getCode(), message, data);
    }

    public static <E> Response<E> build(int code, String message, E data) {
        Response<E> response = new Response<>();
        response.code = code;
        response.message = message;
        response.data = data;
        return response;
    }
}
