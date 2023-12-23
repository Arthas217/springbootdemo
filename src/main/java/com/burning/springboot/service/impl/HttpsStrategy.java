package com.burning.springboot.service.impl;

import com.burning.springboot.common.enums.ProtocolTypeEnum;
import com.burning.springboot.context.ProtocolTypeContext;
import com.burning.springboot.service.ProtocolTypeStrategy;

/**
 * @author 会游泳的蚂蚁
 * @date 2023/12/23 21:40
 */
public class HttpsStrategy implements ProtocolTypeStrategy {
    @Override
    public String protocolParseByContext(ProtocolTypeContext context) {
        return ProtocolTypeEnum.HTTPS.getDesc();
    }
}
