package com.example.web.controller;

import com.example.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author wangfc
 * @desciption
 * @date 2018/7/12
 */
@Slf4j
public class TestControllorTest extends BaseTest {

    @Autowired
    ApplicationContext applicationContext ;

    private MockMvc mvc;


    @Before
    public void setup(){
        /*
         * MockMvcBuilders使用构建MockMvc对象.
         */
        mvc = MockMvcBuilders.webAppContextSetup((WebApplicationContext) applicationContext).build();
    }

    @Test
    public void hello() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.get("/hello");
        MockHttpServletResponse response = mvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse();
        log.info(" status:{},context:{}",response.getStatus(),response.getContentAsString());
    }

    @Test
    public void user() {
    }

    @Test
    public void update() {
    }
}