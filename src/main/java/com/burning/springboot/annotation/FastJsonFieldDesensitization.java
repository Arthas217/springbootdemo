package com.burning.springboot.annotation;

import java.lang.annotation.*;

/**
 * @author 会游泳的蚂蚁
 * @date 2023/12/23 17:18
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FastJsonFieldDesensitization {
}
