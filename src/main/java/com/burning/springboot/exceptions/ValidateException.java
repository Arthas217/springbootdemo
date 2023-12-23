package com.burning.springboot.exceptions;

import com.burning.springboot.common.enums.ResponseStatus;
import com.burning.springboot.response.Response;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 会游泳的蚂蚁
 * @description: 参考https://www.cnblogs.com/yanggb/p/10859907.html
 * @date 2023/12/19 18:37
 */
@ControllerAdvice
public class ValidateException {

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Response validExceptionHandle(BindException bindException) throws Throwable{
        return Response.buildFailed(ResponseStatus.Fail, bindException.getAllErrors().get(0).getDefaultMessage(),null);
    }
}
