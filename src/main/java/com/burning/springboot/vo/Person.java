package com.burning.springboot.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.burning.springboot.serialize.PhoneDesensitization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 会游泳的蚂蚁
 * @date 2023/12/23 16:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @JSONField(serializeUsing = PhoneDesensitization.class)
    String phone;

    String email;

}