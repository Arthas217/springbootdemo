package com.burning.springboot.context;

import com.burning.springboot.common.enums.ProtocolTypeEnum;
import com.burning.springboot.service.ProtocolTypeStrategy;
import lombok.Data;

/**
 * 构造一个上下文，策略基于此上下文来处理，借助上下文定义值枚举做策略路由。
 * @author 会游泳的蚂蚁
 * @date 2023/12/13 12:41
 */
@Data
public class ProtocolTypeContext {

    private ProtocolTypeEnum typeEnum;

    private ProtocolTypeStrategy typeStrategy;

    public String parseRouter(){
        return typeStrategy.protocolParseByContext(this);
    }
}
