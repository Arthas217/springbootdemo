package com.burning.springboot.controller;

import cn.hutool.core.util.ObjectUtil;
import com.burning.springboot.common.utils.AssertUtil;
import com.burning.springboot.response.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 断言检验方式
 * @author 会游泳的蚂蚁
 * @date 2023/12/24 21:30
 */
@RestController
public class AssertController {

    /**
     * 通过断言工具，通过business定义的业务异常，最后通过统一异常处理返回给前端
     * @param serviceOrder
     * @return
     */
    @RequestMapping(value="/assert/business")
    public Response assertBusiness(String serviceOrder){
        AssertUtil.businessInvalid(ObjectUtil.isNull(serviceOrder),"查无此服务单,为null");
        AssertUtil.businessInvalid(serviceOrder.equals("1"),"查无此服务单，值为1");
        AssertUtil.businessInvalid(serviceOrder!= null,"查无此服务单，值不为null");
        return Response.buildSuccess();
    }

}
