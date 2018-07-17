package com.example.web.model;

import lombok.Data;

import java.util.List;

/**
 * @author wangfc
 * @desciption
 * @date 2018/7/10
 */
@Data
public class Result<T> {
    private String code;
    private String msg;
    private List<T> data;

}
