package com.example.web.config;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.Max;
import java.util.List;

/**
 * @author wangfc
 * @desciption
 * @date 2018/7/10
 */
@ConfigurationProperties(prefix = "wung")
//@Validated
@Data
public class MyProperties  {
    @Length(min = 1,max = 3,message = "最小长度为{min},最大长度{max}")
    private String name;
    @Max(value = 2,message = "最大值不能超过{value}")
    private Integer age;
    private List<String> names;

}
