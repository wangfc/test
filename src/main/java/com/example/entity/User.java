package com.example.entity;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author wangfc
 * @desciption
 * @date 2018/7/10
 */
@Entity
@Data
@ApiModel(value = "User" ,description = "用户信息")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "用户id")
    private Long id;
    private String name;
    private Integer age;
    private String departMent;
    @JSONField(format = "yyyy-MM-dd hh:mm:ss sss")
    private Date birthDay;
}
