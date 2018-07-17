package com.example.service;

import com.example.BaseTest;
import com.example.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wangfc
 * @desciption
 * @date 2018/7/11
 */
@Slf4j
public class UserServiceImplTest extends BaseTest {

    @Autowired
    UserService userService;

    @Test
    public void testFindById(){

        User user = userService.findById(2L);
        log.info(" 1userInfo: {} ", user);

        User byId = userService.findById(2L);
        log.info(" 2userInfo: {} ", byId);
    }

    @Test
    public void testDeleteFromCache(){

       userService.deleteFromCache(2L);
    }

    @Test
    public void testSave(){
        userService.save(new User());
    }

    @Test
    public void test()throws Exception{
        User user = new User();
        user.setId(1L);
        user.setName("dd");
        userService.update(user);
    }

}