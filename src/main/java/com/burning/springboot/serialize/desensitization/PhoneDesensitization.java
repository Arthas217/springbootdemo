package com.burning.springboot.serialize.desensitization;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import lombok.Data;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * alibaba fastjson自定义序列化
 *
 * @author 会游泳的蚂蚁
 * @date 2023/12/23 16:31
 */
public class PhoneDesensitization implements ObjectSerializer {
    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        //这里只是做了一个简单
        if (fieldType != String.class) {
            serializer.write(object);
            return;
        }
        StringBuilder phone = new StringBuilder((String) object);
        phone.replace(3, 6, "****");
        serializer.write(phone.toString());

    }
}
