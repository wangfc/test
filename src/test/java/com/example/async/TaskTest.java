package com.example.async;

import com.example.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author wangfc
 * @desciption
 * @date 2018/7/13
 */
@Slf4j
public class TaskTest extends BaseTest {

    @Autowired
    Task task;

    @Test
    public void task1()throws Exception {
        long start = System.currentTimeMillis();
        log.debug("============TaskTest begin==========");
        log.debug("====================================");
                task.task1();
                task.task2();
                task.task3();
        log.debug("============TaskTest end============");
        log.debug("====================================");
        log.debug(" costs {} ms ",System.currentTimeMillis()-start);
    }

    @Test
    public void task2() {

    }

    @Test
    public void task3() {

    }
}