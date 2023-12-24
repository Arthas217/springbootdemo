package com.burning.springboot.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * 令牌桶限流注解
 * @author 会游泳的蚂蚁
 * @date 2023/12/23 22:40
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface Limit {

    // 资源主键,作用：不同的接口，不同的流量控制
    String key() default "";

    //最多访问次数,代表请求总数量
    double permitsPerSeconds();

    // 时间：即timeout时间内,只允许有permitsPerSeconds个请求总数量访问，超过的将被限制不能访问
    long timeout();

    //时间类型
    TimeUnit timeUnit() default TimeUnit.MILLISECONDS;

    //提示信息
    String msg() default "系统繁忙,请稍后重试";

}
