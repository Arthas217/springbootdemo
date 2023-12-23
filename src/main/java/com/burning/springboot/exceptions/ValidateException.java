package com.burning.springboot.exceptions;

import com.burning.springboot.common.enums.ResponseStatus;
import com.burning.springboot.response.Response;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;


/**
 * 参数校验在业务中还要抛出异常或者返回异常时校验信息
 * @author 会游泳的蚂蚁
 * 和ValidateController配合，检验异常
 * 参考https://www.cnblogs.com/yanggb/p/10859907.html
 * @date 2023/12/19 18:37
 */
@ControllerAdvice
public class ValidateException {

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Response validExceptionHandle(BindException bindException){
        return Response.buildFailed(ResponseStatus.PARAM_INVALID, bindException.getAllErrors().get(0).getDefaultMessage(),null);
    }
}
