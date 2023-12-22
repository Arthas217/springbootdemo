package com.burning.springboot.controller;

import com.burning.springboot.vo.JsonSerializerVO;
import com.burning.springboot.vo.JsonSerializerVO2;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.burning.springboot.common.utils.RsaUtil.getKeyPair;

/**
 * 过敏数据
 * 遗留问题 1） 对于密钥很长的数据如何返给前端，2） 对于主键int类型的id值，如何脱敏
 *
 * @author 会游泳的蚂蚁
 * @date 2023/12/22 10:55
 */
@RestController
public class JsonSerializerController {

    @RequestMapping("/test")
    public JsonSerializerVO testDesensitization(Boolean enable) throws Exception {
        if (enable == null) {
            return new JsonSerializerVO();
        }
        KeyPair keyPair = getKeyPair();
        String privateKey = new String(Base64.encodeBase64(keyPair.getPrivate().getEncoded()));
        String publicKey = new String(Base64.encodeBase64(keyPair.getPublic().getEncoded()));
        String shortPriKey = getShortKey(privateKey);
        String shortPubKey = getShortKey(publicKey);
        // 脱敏数据
        if (enable) {
            JsonSerializerVO serializerVO = new JsonSerializerVO();
            serializerVO.setUserName("我是用户名");
            serializerVO.setAddress("地球中国-北京市通州区2号楼");
            serializerVO.setPhone("13782946666");
            serializerVO.setPassword("chxg123123123");
            serializerVO.setPublicKey(shortPubKey);
            serializerVO.setPrivateKey(shortPriKey);
            System.out.println(serializerVO);
            return serializerVO;
        }
        JsonSerializerVO2 serializerVO2 = new JsonSerializerVO2();
        serializerVO2.setUserName("我是用户名");
        serializerVO2.setAddress("地球中国-北京市通州区2号楼");
        serializerVO2.setPhone("13782946666");
        serializerVO2.setPassword("chxg123123123");
        serializerVO2.setPublicKey(publicKey);
        serializerVO2.setPrivateKey(privateKey);
        System.out.println(serializerVO2);
        return serializerVO2;
    }


    private String getShortKey(String originalString) throws NoSuchAlgorithmException {
//        String originalString = "Java学习 + 面试指南：javaguide.cn";
        // 创建MD5摘要对象
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(originalString.getBytes(StandardCharsets.UTF_8));
        // 计算哈希值
        byte[] result = messageDigest.digest();
        // 将哈希值转换为十六进制字符串
        String hexString = new HexBinaryAdapter().marshal(result);
        System.out.println("Original String: " + originalString);
        System.out.println("SHA-256 Hash: " + hexString.toLowerCase());
        return hexString.toLowerCase();

    }
}

