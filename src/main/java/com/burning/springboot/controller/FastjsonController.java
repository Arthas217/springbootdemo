package com.burning.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.burning.springboot.common.enums.ResponseStatus;
import com.burning.springboot.response.Response;
import com.burning.springboot.serialize.desensitization.FastJsonSerializeFilter;
import com.burning.springboot.vo.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据过敏测试
 * https://juejin.cn/post/7067916686141161479#heading-3
 * @author 会游泳的蚂蚁
 * @date 2023/12/23 16:38
 */
@RestController
public class FastjsonController {

    @RequestMapping("/fastjson")
    public String fastjson() throws Exception {
        Person person = new Person("13111121552", "123455", "zlk@gmail.com");
        return JSON.toJSONString(person);
    }

    @RequestMapping(value = "/fastjson2")
    public Response fastjson2() {
        Person person = new Person("13111121552", "123455", "zlk@gmail.com");
        return Response.buildSuccess(ResponseStatus.SUCCESS, JSON.toJSONString(person));
    }


    @RequestMapping(value = "/fastjson3")
    public Response fastjson3() {
        Person person = new Person("13111121552", "123456789", "zlk@gmail.com");
        return Response.buildSuccess(ResponseStatus.SUCCESS, JSON.toJSONString(person,new FastJsonSerializeFilter()));
    }
}
