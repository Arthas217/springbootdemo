package com.burning.springboot.aspect;

import com.burning.springboot.annotation.Limit;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.RateLimiter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * 基于guava令牌桶的限流切面
 * https://mp.weixin.qq.com/s/A5VYjstIDeVvizNK2HkrTQ
 * @author 会游泳的蚂蚁
 * @date 2023/12/24 09:07
 */
@Aspect
@Component
public class LimitAspect {

    private final Map<String, RateLimiter> limitMap = Maps.newConcurrentMap();
    private boolean acquire;

    @Around("@annotation(com.burning.springboot.annotation.Limit)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取method的注解
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Limit limit = method.getAnnotation(Limit.class);
        if (limit != null) {
            String key = limit.key();
            RateLimiter rateLimiter;
            //验证缓存是否有命中key
            if (!limitMap.containsKey(key)) {
                rateLimiter = RateLimiter.create(limit.permitsPerSeconds());
                limitMap.put(key, rateLimiter);
            }
            rateLimiter = limitMap.get(key);
            //拿令牌
            acquire = rateLimiter.tryAcquire(limit.timeout(), limit.timeUnit());
            //拿不到令牌，直接返回异常信息
            if (!acquire) {
                throw new RuntimeException(limit.msg());
            }
        }
        return joinPoint.proceed();

    }
}
