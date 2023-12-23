package com.burning.springboot.service;

import com.burning.springboot.context.ProtocolTypeContext;

/**
 * 协议类型策略
 * @author 会游泳的蚂蚁
 * @date 2023/12/13 12:39
 */
public interface ProtocolTypeStrategy {

    /**
     * 基于上下文协议解析desc
     * @param context 引入策略上下文
     * @return
     */
    String protocolParseByContext(ProtocolTypeContext context);
}
