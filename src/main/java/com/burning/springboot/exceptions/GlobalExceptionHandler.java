package com.burning.springboot.exceptions;

import com.burning.springboot.common.enums.ResponseStatus;
import com.burning.springboot.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一异常处理
 *
 * @author 会游泳的蚂蚁
 * @date 2023/12/24 13:39
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public Response businessExceptionHandler(BusinessException e) {
        log.info("business error : {}", e.getMessage(), e);
        //目前理解此接口返回失败
        if (e.getCode() == -1) {
            return Response.buildFailed(ResponseStatus.Fail, null);
        }
        //返回业务定义异常
        return Response.buildFailed(e.getCode(), e.getMessage());
    }


    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Response validExceptionHandle(BindException bindException) {
        return Response.buildFailed(ResponseStatus.PARAM_INVALID, bindException.getAllErrors().get(0).getDefaultMessage(), null);
    }


    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Response nullPointerExceptionHandle(NullPointerException nullPointerException) {
        return Response.buildFailed(ResponseStatus.NULL_POINT, nullPointerException.getMessage(), null);
    }


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Response exceptionHandler(HttpServletRequest req, Exception e) {
        return Response.buildFailed(ResponseStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
    }

}
