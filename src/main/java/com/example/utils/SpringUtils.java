package com.example.utils;

import com.example.Application;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * @author wangfc
 * @desciption
 * @date 2018/7/10
 */
@Component
public class SpringUtils implements ApplicationContextAware {

    private static ApplicationContext ac = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (ac == null ){
            ac = applicationContext ;
        }
    }

    public static ApplicationContext getApplicationContext(){
        Assert.notNull(ac,"ApplicationContext初始化失败");
        return ac;
    }

    public static <T> T getBean(Class<T> clazz ){
        return getApplicationContext().getBean(clazz);
    }

    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }
}
