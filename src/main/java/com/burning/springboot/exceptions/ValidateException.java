package com.burning.springboot.exceptions;

import com.burning.springboot.common.enums.ResponseStatus;
import com.burning.springboot.response.Response;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/**
 * 参数校验在业务中还要抛出异常或者返回异常时校验信息
 *
 * @author 会游泳的蚂蚁
 * 和ValidateController配合，检验异常
 * 参考https://www.cnblogs.com/yanggb/p/10859907.html
 * @date 2023/12/19 18:37
 */
@ControllerAdvice
@Deprecated
public class ValidateException {

//    @ExceptionHandler(BindException.class)
//    @ResponseBody
//    public Response validExceptionHandle(BindException bindException) {
//        return Response.buildFailed(ResponseStatus.PARAM_INVALID, bindException.getAllErrors().get(0).getDefaultMessage(), null);
//    }
//
//    @ExceptionHandler(NullPointerException.class)
//    @ResponseBody
//    public Response nullPointerExceptionHandle(NullPointerException nullPointerException) {
//        return Response.buildFailed(ResponseStatus.NULL_POINT, nullPointerException.getMessage(), null);
//    }
//
//
//    @ExceptionHandler(value =Exception.class)
//    @ResponseBody
//    public Response exceptionHandler(HttpServletRequest req, Exception e){
//        return Response.buildFailed(ResponseStatus.INTERNAL_SERVER_ERROR,e.getMessage(),null);
//    }





    /**
     * 处理限流异常时，处理业务异常，这么看来这个类就是可以任务是一个全局异常类，针对每种异常，定义异常处理
     * 但是现在问题是 运行时异常不只是有这个limit异常，如果其他运行时异常那么这样就不合适了。
     * @param runtimeException
     * @return
     */
//    @ExceptionHandler(RuntimeException.class)
//    @ResponseBody
//    public Response validExceptionHandle(RuntimeException runtimeException) {
//        return Response.buildFailed(ResponseStatus.LIMIT_RATE, runtimeException.getMessage(), null);
//    }

}
