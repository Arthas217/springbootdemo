package com.burning.springboot.common.enums;

import com.burning.springboot.context.ProtocolTypeContext;
import com.burning.springboot.service.impl.HttpStrategy;
import com.burning.springboot.service.impl.HttpsStrategy;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 协议类型枚举
 *
 * @author 会游泳的蚂蚁
 * @date 2023/12/13 10:23
 */
public enum ProtocolTypeEnum {

    HTTP(1, "http"),
    HTTPS(2, "https"),
    WEBSOCKET(3, "websocket"),
    TCP(4, "tco");

    private int code;
    private String desc;

    ProtocolTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }


    /*枚举遍历方式改成map方式*/
    private static Map<Integer, ProtocolTypeEnum> CODE_MAP = Arrays.stream(ProtocolTypeEnum.values()).collect(Collectors.toMap(ProtocolTypeEnum::getCode, Function.identity()));
    private static Map<String, ProtocolTypeEnum> NAME_MAP = Arrays.stream(ProtocolTypeEnum.values()).collect(Collectors.toMap(ProtocolTypeEnum::name, Function.identity()));

    /* 获取枚举类 */
    public static ProtocolTypeEnum getByCode(int code) {
        return CODE_MAP.get(code);
    }

    public static ProtocolTypeEnum getByName(String name) {
        return NAME_MAP.get(name);
    }

    /* code方式*/
    public static String parseDescByCode(int code) {
        return Optional.ofNullable(getByCode(code)).map(ProtocolTypeEnum::getDesc).orElse(null);
    }

    /* name方式*/
    public static String parseDescByName(String name) {
        return Optional.ofNullable(getByName(name)).map(ProtocolTypeEnum::getDesc).orElse(null);
    }


    /*策略模式，简单实现方式*/
    public static String parseDescByStrategy(int code) {
        ProtocolTypeEnum protocolTypeEnum = ProtocolTypeEnum.getByCode(code);
        //引入上下文，借助枚举做策略路由。
        ProtocolTypeContext context = new ProtocolTypeContext();
        context.setTypeEnum(protocolTypeEnum);
        switch (code) {
            case 1:
                context.setTypeStrategy(new HttpStrategy());
                break;
            case 2:
                context.setTypeStrategy(new HttpsStrategy());
                break;
            default:
                return null;
        }
        return context.parseRouter();
    }

}

