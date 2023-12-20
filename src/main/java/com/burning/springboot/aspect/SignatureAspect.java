package com.burning.springboot.aspect;

import com.burning.springboot.common.enums.BaseEnum;
import com.burning.springboot.common.enums.ResponseStatus;
import com.burning.springboot.response.Response;
import org.apache.tomcat.util.codec.binary.Base64;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.security.KeyPair;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static com.burning.springboot.common.utils.RsaUtil.*;

/**
 * @author 会游泳的蚂蚁
 * @description:
 * @date 2023/12/20 10:19
 */
@Aspect
@Component
public class SignatureAspect {

    private static KeyPair keyPair;

    private static Map<String, String> keyMap = new ConcurrentHashMap<>();

    @Around("@annotation(com.burning.springboot.annotation.Signature)")
    public Object verifySignature(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        //获取请求类父子类属性值
        Map<String, Object> fieldMap = classFieldMap(args);
        // appid和signature判断检验
        // 按首字母升序排序拼接签名字符串
        String data = signatureData(fieldMap);
        // 签名和验签 (公私钥可以放入mysql)
        // https://www.cnblogs.com/zhangww/p/10846216.html
        String publicKey = "";
        String privateKey = "";
        if (keyMap.containsKey("PUB")) {
            publicKey = keyMap.get("PUB");
            privateKey = keyMap.get("PRI");
        } else {
            keyPair = getKeyPair();
            privateKey = new String(Base64.encodeBase64(keyPair.getPrivate().getEncoded()));
            publicKey = new String(Base64.encodeBase64(keyPair.getPublic().getEncoded()));
            keyMap.put("PUB", publicKey);
            keyMap.put("PRI", privateKey);
        }
        String sign1 = signSha256withRSA(data, privateKey);
        String signature = (String) fieldMap.get("signature");

        boolean verifySHA256WithRSA = signVerifySHA256WithRSA(data, publicKey, signature);
        if (!verifySHA256WithRSA) {
//            return Response.buildFailed(ResponseStatus.SIGNATURE_FAIL);
            return Response.buildFailed(ResponseStatus.SIGNATURE_FAIL, signature, sign1);
        }
        return joinPoint.proceed();
    }

    private String signatureData(Map<String, Object> fieldMap) {
        Map<String, Object> notNullMap = fieldMap.entrySet().stream().filter(entry -> entry.getKey() != null && entry.getValue() != null
                && !"signature".equals(entry.getKey())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        TreeMap<String, Object> treeMap = new TreeMap<>(notNullMap);
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Object> entry : treeMap.entrySet()) {
            stringBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    private Map<String, Object> classFieldMap(Object[] args) throws IllegalAccessException {
        Map<String, Object> result = new ConcurrentHashMap<>();
        Class<?> clazz = args[0].getClass();
        while (clazz != Object.class) {
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field field : declaredFields) {
                if (!Objects.isNull(field)) {
                    field.setAccessible(true);
                    Class<?> type = field.getType();
                    if (type.isEnum()) {
                        BaseEnum baseEnum = (BaseEnum) field.get(args[0]);
                        result.put(field.getName(), baseEnum.getCode());
                    } else {
                        result.put(field.getName(), field.get(args[0]));
                    }
                }
            }
            clazz = clazz.getSuperclass();
        }
        return result;
    }
}
