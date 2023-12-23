package com.burning.springboot.controller;

import com.burning.springboot.annotation.Signature;
import com.burning.springboot.response.Response;
import com.burning.springboot.vo.Employee;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 参数检验validate测试
 * @author 会游泳的蚂蚁
 * @date 2023/12/19 18:13
 */
@RestController
public class ValidateController {

    /**
     * @param employee
     * @return
     */
    @RequestMapping(value = "/validate",method = RequestMethod.POST)
    @Signature
    public Response validate(@Validated Employee employee) {
        return Response.buildSuccess();
    }

}
