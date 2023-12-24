package com.burning.springboot.common.enums;

import lombok.Data;

/**
 * @author 会游泳的蚂蚁
 * @description: 响应状态码
 * @date 2023/12/20 12:13
 */
public enum ResponseStatus {

    SUCCESS(0, "成功"),
    Fail(-1, "失败"),
    PARAM_INVALID(1, "参数不合法"),
    SIGNATURE_FAIL(2, "验签失败"),
    LIMIT_RATE(3, "接口限流"),
    NULL_POINT(4, "空指针异常"),
    INTERNAL_SERVER_ERROR(5, "服务器内部未知异常");
    private Integer code;
    private String desc;

    ResponseStatus(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
