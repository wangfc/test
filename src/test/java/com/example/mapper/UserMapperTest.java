package com.example.mapper;

import com.example.BaseTest;
import com.example.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author wangfc
 * @desciption
 * @date 2018/7/12
 */
@Slf4j
public class UserMapperTest extends BaseTest {

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserDao userDao;

    @Test
    public void findById() {
        log.info("userInfo={}",userMapper.findById(1L));
        log.info("userinfo jpa = {}",userDao.findById(1L).get());
    }


}