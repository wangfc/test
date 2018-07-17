package com.example.aspect;

import java.lang.annotation.*;

/**
 * @author wangfc
 * @desciption
 * @date 2018/7/11
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String value() default "DS";
}
