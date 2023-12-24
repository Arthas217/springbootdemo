package com.burning.springboot.controller;

import com.burning.springboot.annotation.Limit;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 令牌桶限流
 * https://mp.weixin.qq.com/s/A5VYjstIDeVvizNK2HkrTQ
 * @author 会游泳的蚂蚁
 * @date 2023/12/24 09:27
 */
@RestController
public class RateLimitController {

    @RequestMapping(value = "/limit", method = RequestMethod.GET)
    @Limit(key = "query", permitsPerSeconds = 1, timeout = 1, timeUnit = TimeUnit.SECONDS, msg = "触发接口限流，请重试")
    public String  limit() {
        return "业务返回值";
    }
}
