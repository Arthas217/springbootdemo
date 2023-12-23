package com.burning.springboot.config;

import com.datastax.oss.driver.api.core.CqlSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;

/**
 * Cassandra实例化配置类
 * @author 会游泳的蚂蚁
 * @date 2023/12/20 20:22
 */
@Slf4j
@Configuration
public class CassnadraConfig {

//    @Bean
//    public CqlSession cqlSession() {
//        return CqlSession.builder().
//                addContactPoint(new InetSocketAddress("", 9042)).
//                withLocalDatacenter("datacenter1").
//                withKeyspace("msxf").build();
//    }
}
