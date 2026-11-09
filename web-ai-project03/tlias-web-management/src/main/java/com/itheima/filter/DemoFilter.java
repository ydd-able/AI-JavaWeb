package com.itheima.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author ydd
 * @project IntelliJ IDEA
 */
@Slf4j
//@WebFilter(urlPatterns = "/*")//拦截所有请求。
public class DemoFilter implements Filter {
    //初始化方法，在web服务器启动的时候执行,只执行一次。
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("初始化方法");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //拦截到了请求。
        log.info("拦截到了请求。。。");
        //放行。
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        log.info("destroy 销毁方法");
    }
}
