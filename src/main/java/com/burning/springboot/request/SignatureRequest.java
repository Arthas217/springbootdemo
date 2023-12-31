package com.burning.springboot.request;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * 签名请求参数
 * @author 会游泳的蚂蚁
 * @date 2023/12/20 10:06
 */
@Data
public class SignatureRequest {
    @NotNull(message = "appid不能为空")
    private Integer appId;
    @NotBlank(message ="签名串不能为空")
    private String signature;
}
