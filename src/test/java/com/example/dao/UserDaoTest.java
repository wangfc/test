package com.example.dao;

import com.alibaba.fastjson.JSON;
import com.example.Application;
import com.example.entity.User;
import com.example.utils.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Iterator;
import java.util.List;

/**
 * @author wangfc
 * @desciption
 * @date 2018/7/10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration
@Slf4j
public class UserDaoTest {

    @Autowired
    UserDao userDao;

    @Test
    public void test(){
        System.out.println(SpringUtils.getApplicationContext());
        Iterator<User> all = SpringUtils.getApplicationContext().getBean(UserDao.class).findAll().iterator();
        while (all.hasNext()){
            User next = all.next();
            log.debug("id:{},name:{}",next.getId(),next.getName());
        }

    }

    @Test
    public void findByName(){
        User byName = userDao.findByName("55ss");
        log.info(JSON.toJSONString(byName));
    }

    @Test
    public void findByAgeBetween(){
        List<User> list = userDao.findByAgeBetween(1,50, Sort.by("age").descending());
        log.info(JSON.toJSONString(list));
    }
}