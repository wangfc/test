package com.example.web.filter;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author wangfc
 * @desciption
 * @date 2018/7/10
 */
@WebFilter(filterName = "myFilter" , urlPatterns = "/*")
@Slf4j
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("==============================================");
        log.info("============== init MyFilter =================");
        log.info("==============================================");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("执行过滤操作");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("==============================================");
        System.out.println("============== destroy MyFilter ==============");
        System.out.println("==============================================");
    }
}
