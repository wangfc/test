package com.example.web.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author wangfc
 * @desciption
 * @date 2018/7/10
 */
@Data
public class User {
    private Integer userId;
    private String name;
    private Integer age;

}
