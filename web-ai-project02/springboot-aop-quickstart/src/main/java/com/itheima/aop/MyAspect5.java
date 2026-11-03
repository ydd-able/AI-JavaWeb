package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author ydd
 * @project IntelliJ IDEA
 */
@Slf4j
@Aspect
@Component
public class MyAspect5 {
//    @Before("execution(*com.itheima.service.impl.DeptServiceImpl.list(..)) ||" +
//  "execution(*com.itheima.service.impl.DeptServiceImpl.delete(..))")
    @Before("@annotation(com.itheima.anno.LogOperation)")
    public void before() {
        log.info("MyAspect5 -> before...");
    }
}
