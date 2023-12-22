package com.burning.springboot.controller;

import com.burning.springboot.vo.JsonSerializerVO;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.KeyPair;

import static com.burning.springboot.common.utils.RsaUtil.getKeyPair;

/**
 * 过敏数据
 * @author 会游泳的蚂蚁
 * @date 2023/12/22 10:55
 */
@RestController
public class JsonSerializerController {


    @RequestMapping("/test")
    public JsonSerializerVO testDesensitization() throws Exception {
        KeyPair keyPair= getKeyPair();
        String privateKey = new String(Base64.encodeBase64(keyPair.getPrivate().getEncoded()));
        String publicKey = new String(Base64.encodeBase64(keyPair.getPublic().getEncoded()));
        JsonSerializerVO serializerVO = new JsonSerializerVO();
        serializerVO.setUserName("我是用户名");
        serializerVO.setAddress("地球中国-北京市通州区2号楼");
        serializerVO.setPhone("13782946666");
        serializerVO.setPassword("chxg123123123");
        serializerVO.setPublicKey(publicKey);
        serializerVO.setPrivateKey(privateKey);
        System.out.println(serializerVO);
        return serializerVO;
    }

}
