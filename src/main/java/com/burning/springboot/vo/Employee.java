package com.burning.springboot.vo;

import com.burning.springboot.request.SignatureRequest;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * 测试签名，测试validate参数校验，雇员实体类
 * @author 会游泳的蚂蚁
 * @date 2023/12/19 18:12
 */
@Data
public class Employee extends SignatureRequest {

    @NotBlank(message = "姓名不能为空")
    @Length(message = "长度不能超过{max}字符", max = 10)
    private String name;

    @NotNull(message = "年龄不能为空")
    private Integer age;

}
