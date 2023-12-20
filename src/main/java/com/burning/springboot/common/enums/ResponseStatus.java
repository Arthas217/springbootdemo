package com.burning.springboot.common.enums;

import lombok.Data;

/**
 * @author 会游泳的蚂蚁
 * @description:
 * @date 2023/12/20 12:13
 */
public enum ResponseStatus {

    SUCCESS(0,"成功"),
    Fail(-1,"失败"),
    SIGNATURE_FAIL(1,"验签失败");
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
