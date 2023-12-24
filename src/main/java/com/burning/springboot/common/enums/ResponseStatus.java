package com.burning.springboot.common.enums;

import lombok.Data;

/**
 * @author 会游泳的蚂蚁
 * @description: 响应状态码
 * @date 2023/12/20 12:13
 */
public enum ResponseStatus {

    SUCCESS(0, "成功"),

    FAIL(-1, "网络异常，请稍后再试"),

    PARAM_INVALID(1, "参数不合法"),

    SIGNATURE_FAIL(2, "验签失败"),

    LIMIT_RATE(3, "接口限流"),

    NULL_POINT(4, "空指针异常"),

    INTERNAL_SERVER_ERROR(5, "服务器内部未知异常"),

    USER_NOT_LOGIN(1002, "用户未登录，请重新登录"),

    USER_HAS_EXIST_LOGIN(1007, "用户已经存在，请检查！"),

    USER_CODE_NOT_EXIST(1008, "用户编码不存在，请检查！"),

    REQUEST_PARAMS_FORMAT_ERROR(1102, "请求参数格式异常"),

    PASSWORD_SAFETY_ERROE(2204, "密码不符合安全规则，请通过忘记密码重新设置8-18位数字+字母组合密码"),

    TOKEN_EXPIRED(2301, "token过期"),

    TOKEN_ERROR(2302, "token验证失败");

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
