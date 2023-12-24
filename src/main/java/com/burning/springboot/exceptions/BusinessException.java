package com.burning.springboot.exceptions;

import java.util.logging.Level;

/**
 * 业务异常，异常信息会返回到前端展示给用户
 *
 * @author 会游泳的蚂蚁
 * @date 2023/12/24 09:51
 */
public class BusinessException extends RuntimeException {

    private int code = 1;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    private Level level;

    public BusinessException(Level level, String message) {
        super(message);
        this.level = level;
    }


    public int getCode() {
        return this.code;
    }

    public final Level getLevel() {
        return this.level;
    }
}
