package com.burning.springboot.context;

import com.burning.springboot.common.enums.ProtocolTypeEnum;
import com.burning.springboot.service.ProtocolTypeStrategy;
import com.burning.springboot.service.impl.HttpsStrategy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 引入容器，保存枚举值及对应策略映射
 * @author 会游泳的蚂蚁
 * @date 2023/12/23 22:00
 */
@Component
public class ProtocolTypeContainer {

    public final static Map<ProtocolTypeEnum, ProtocolTypeStrategy> ENUM_STRATEGY_MAP = new HashMap<>();

    @PostConstruct
    public void init(){
        ENUM_STRATEGY_MAP.put(ProtocolTypeEnum.HTTP,new HttpsStrategy());
        ENUM_STRATEGY_MAP.put(ProtocolTypeEnum.HTTPS,new HttpsStrategy());
    }

    public String parseDescByContainer(ProtocolTypeContext context){
        return Optional.ofNullable(ENUM_STRATEGY_MAP.get(context.getTypeEnum())).
                map(strategy-> strategy.protocolParseByContext(context)).orElse(null);
    }
}
