package com.burning.springboot.vo;

import com.burning.springboot.annotation.Desensitization;
import com.burning.springboot.common.enums.DesensitizationTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 会游泳的蚂蚁
 * @date 2023/12/22 10:49
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonSerializerVO {

    private String userName;

    @Desensitization(type = DesensitizationTypeEnum.MOBILE_PHONE)
    private String phone;

    @Desensitization(type = DesensitizationTypeEnum.PASSWORD)
    private String password;

    @Desensitization(type = DesensitizationTypeEnum.MY_RULE, startInclude = 2,endExclude = -2,enable =true)
    private String address;

    @Desensitization(type = DesensitizationTypeEnum.MY_RULE, startInclude = 2,endExclude = -2,enable =true)
    private String publicKey;

    @Desensitization(type = DesensitizationTypeEnum.MY_RULE, startInclude = 2,endExclude = -2,enable =true)
    private String privateKey;
}
