package com.example.web.config;

import com.alibaba.fastjson.JSON;
import com.example.BaseTest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author wangfc
 * @desciption
 * @date 2018/7/10
 */
public class MyPropertiesTest extends BaseTest {

    @Resource
    MyProperties myProperties;

    @Test
    public void test() {

        System.out.println(JSON.toJSONString(myProperties));
    }
}