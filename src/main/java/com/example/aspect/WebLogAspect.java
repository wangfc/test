package com.example.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author wangfc
 * @desciption
 * @date 2018/7/12
 */
@Component
@Aspect
@Order(-5)
@Slf4j
public class WebLogAspect {

    private static ThreadLocal<Long> TIME_CONTEXT = new ThreadLocal<>();

    @Pointcut("execution(public * com.example.web..*Controllor.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void before(JoinPoint joinPoint){
        TIME_CONTEXT.set(System.currentTimeMillis());
        log.debug("WebLogAspect before()...");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        log.info("URL : " + request.getRequestURL().toString());
        log.info("HTTP_METHOD : " + request.getMethod());
        log.info("IP : " + request.getRemoteAddr());
        log.info("CLASS_METHOD : {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("getDeclaringType:{}",joinPoint.getSignature().getDeclaringType());
        log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        /*//获取所有参数方法一：
        Enumeration<String> enu=request.getParameterNames();
        while(enu.hasMoreElements()){
            String paraName=(String)enu.nextElement();
            System.out.println(paraName+": "+request.getParameter(paraName));
        }*/
    }

    @AfterReturning(value = "webLog()",returning = "ret")
    public void afterReturning(JoinPoint joinPoint,Object ret){
        // 处理完请求，返回内容
        log.info("WebLogAspect.afterReturning()...");
        log.info("return value:{}",ret);
        log.info("it's cost {} ms ",System.currentTimeMillis() - TIME_CONTEXT.get());
        TIME_CONTEXT.remove();
    }
}
