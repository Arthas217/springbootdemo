package com.burning.springboot.zlk;

import com.burning.springboot.common.enums.ProtocolTypeEnum;
import com.burning.springboot.context.ProtocolTypeContainer;
import com.burning.springboot.context.ProtocolTypeContext;

import static com.burning.springboot.common.enums.ProtocolTypeEnum.*;

/**
 * 枚举方式引发的思考
 * https://mp.weixin.qq.com/s/Vt_mdLicWwkZ8phD1rH6UQ
 *
 * @author 会游泳的蚂蚁
 * @date 2023/12/23 21:10
 */
public class ProtocolType {

    public static void main(String[] args) {
        String name = ProtocolTypeEnum.HTTP.name();
        int code = ProtocolTypeEnum.HTTP.getCode();
        int code1 = ProtocolTypeEnum.HTTPS.getCode();
        String desc = ProtocolTypeEnum.HTTP.getDesc();
        System.out.println(String.format("枚举name=%s,code=%s,code1=%s,desc=%s", name, code, code1, desc));
        System.out.println(String.format("通过枚举code值，返回desc方式：%s", parseDescByCode(code)));
        System.out.println(String.format("通过枚举name值，返回desc方式：%s", parseDescByName(name)));
        System.out.println(String.format("通过策略输入code1值，返回desc方式%s", parseDescByStrategy(code1)));

        ProtocolTypeContainer container = new ProtocolTypeContainer();
        container.init();// 模拟bean注入
        ProtocolTypeContext context = new ProtocolTypeContext();
        context.setTypeEnum(HTTPS);
        System.out.println(String.format("通过中间层容器工厂，解耦依赖(调用方通过策略实现路由过程),手动容器方式，返回desc为%s", container.parseDescByContainer(context)));

    }
}
