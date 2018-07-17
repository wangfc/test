package com.example.web;

import com.example.web.model.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wangfc
 * @desciption 统一异常处理
 * @date 2018/7/10
 */
@ControllerAdvice
@ResponseBody
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result defaultErrorHandler(HttpServletRequest request, Exception e){

        e.printStackTrace();

        System.out.println("11GlobalDefaultExceptionHandler.defaultErrorHandler()");
        Result result =  new Result();
        result.setCode("9999");
        result.setMsg("系统繁忙，请稍候再试！");
        return result;
    }
}
