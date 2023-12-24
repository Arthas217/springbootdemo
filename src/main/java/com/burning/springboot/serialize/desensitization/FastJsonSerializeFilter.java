package com.burning.springboot.serialize.desensitization;

import com.alibaba.fastjson.serializer.ValueFilter;
import com.burning.springboot.annotation.FastJsonFieldDesensitization;

/**
 * 自定义序列化过滤器 SerializeFilter接口
 * https://juejin.cn/post/7067916686141161479
 *
 * @author 会游泳的蚂蚁
 * @date 2023/12/23 17:15
 */
public class FastJsonSerializeFilter implements ValueFilter {

    @Override
    public Object process(Object object, String name, Object value) {
        try {
            //这里可以增加缓存
            FastJsonFieldDesensitization annotation = object.getClass().getDeclaredField(name).getAnnotation(FastJsonFieldDesensitization.class);
            if (annotation == null) {
                return value;
            }
            if (!(value instanceof String)) {
                return value;
            }
            StringBuilder cardId = new StringBuilder((String) value);
            cardId.replace(3, 6, "****");
            return cardId;
        } catch (NoSuchFieldException e) {
        }
        return value;
    }

}
