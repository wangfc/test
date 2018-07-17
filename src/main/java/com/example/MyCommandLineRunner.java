package com.example;

import com.example.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author wangfc
 * @desciption
 * @date 2018/7/10
 */
@Component
@Order(2)
@Slf4j
public class MyCommandLineRunner implements CommandLineRunner {

    @Resource
    private UserDao userDao;

    @Override
    public void run(String... args) throws Exception {
        log.info("加载外部资源===");
  /*      userDao.findAll().forEach(new Consumer<User>() {
            @Override
            public void accept(User user) {
                log.debug("id:{},name:{}",user.getId(),user.getName());
            }
        });*/
    }
}
