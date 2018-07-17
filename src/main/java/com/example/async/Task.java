package com.example.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author wangfc
 * @desciption
 * @date 2018/7/13
 */
@Component
@Slf4j
public class Task {

    @Async
    public void task1()throws Exception{
        log.debug(" task1 beginging");
        long start = System.currentTimeMillis();
        int i = new Random().nextInt(10000);
        Thread.sleep(i);
        log.debug(" task1 end, cost {} ms",System.currentTimeMillis()-start);
    }

    @Async
    public void task2()throws Exception{
        log.debug(" task2 beginging");
        long start = System.currentTimeMillis();
        int i = new Random().nextInt(10000);
        Thread.sleep(i);
        log.debug(" task2 end, cost {} ms",System.currentTimeMillis()-start);
    }

    @Async
    public void task3()throws Exception{
        log.debug(" task3 beginging");
        long start = System.currentTimeMillis();
        int i = new Random().nextInt(10000);
        Thread.sleep(i);
        log.debug(" task3 end, cost {} ms",System.currentTimeMillis()-start);
    }

}
