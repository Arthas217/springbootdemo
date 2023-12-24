package com.burning.springboot.common.utils;

import com.burning.springboot.common.enums.ResponseStatus;
import com.burning.springboot.exceptions.BusinessException;

/**
 * 断言工具类
 * @author 会游泳的蚂蚁
 * @date 2023/12/24 13:42
 */
public class AssertUtil {

    public AssertUtil() {
    }

    /**
     * 抛出异常
     * @param message
     */
    public static void businessInvalid(String message) {
        throw new BusinessException(ResponseStatus.INTERNAL_SERVER_ERROR.getCode(), message);
    }

    /**
     * 表达式为真即抛出异常
     *
     * @param expression
     * @param message
     */
    public static void businessInvalid(boolean expression, String message) {
        if (expression) {
            throw new BusinessException(ResponseStatus.INTERNAL_SERVER_ERROR.getCode(), message);
        }
    }

    /**
     * 表达式为真即抛出异常
     *
     * @param expression
     * @param message
     */
    public static void businessInvalid(boolean expression, int code, String message) {
        if (expression) {
            throw new BusinessException(code, message);
        }
    }
}
