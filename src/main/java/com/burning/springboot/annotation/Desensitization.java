package com.burning.springboot.annotation;


import com.burning.springboot.common.enums.DesensitizationTypeEnum;
import com.burning.springboot.serialize.DesensitizationSerialize;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 脱敏注解
 * @author 会游泳的蚂蚁
 * @date 2023/12/22 10:40
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside//被此注解标记的Desensitization注解可以被应用在Jackson库中的其他注解上，以实现更灵活的注解组合和嵌套使用。
@JsonSerialize(using = DesensitizationSerialize.class)//指定在将 Java 对象序列化为 JSON 格式时使用的自定义序列化器。通
public @interface Desensitization {

    /**
     * 脱敏数据类型，在MY_RULE的时候，startInclude和endExclude生效
     */
    DesensitizationTypeEnum type() default DesensitizationTypeEnum.MY_RULE;

    /**
     * 脱敏开始位置（包含）
     */
    int startInclude() default 0;

    /**
     * 脱敏结束位置（不包含）
     * 支持负数（-1：字符串倒数第一个字符)
     */
    int endExclude() default 0;

}
