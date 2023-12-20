package com.burning.springboot.controller;

import com.burning.springboot.annotation.Signature;
import com.burning.springboot.common.enums.ResponseStatus;
import com.burning.springboot.response.Response;
import com.burning.springboot.vo.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 会游泳的蚂蚁
 * @description:
 * @date 2023/12/19 18:13
 */
@RestController
public class ValidateController {

    /**
     * @param employee
     * @return
     */
//    @GetMapping("/validate")
    @RequestMapping(value = "/validate",method = RequestMethod.POST)
    @Signature
    public Response validate(@Validated Employee employee) {
        return Response.buildSuccess();
    }

}
