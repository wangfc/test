package com.example.scheduling;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/**
 * @author wangfc
 * @desciption
 * @date 2018/7/10
 */
@Configuration
@EnableScheduling
public class SchedulingConfig {

/*    @Scheduled(cron = "0/8 * * * * ?")
    public void scheduled(){
        System.out.println(new Date());
    }*/
}
