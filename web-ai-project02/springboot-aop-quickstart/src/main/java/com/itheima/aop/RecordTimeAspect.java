package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author ydd
 * @project IntelliJ IDEA
 */
@Slf4j
@Component
@Aspect//标记当前是一个aop类
public class RecordTimeAspect {
    @Around("execution(* com.itheima.service.impl.*.*(..))")
    public Object recordTime(ProceedingJoinPoint pjp) throws Throwable {
        long begin = System.currentTimeMillis();
        Object result = pjp.proceed();
        long end = System.currentTimeMillis();
        log.info("方法{}执行好事{}ms",pjp.getSignature(), end - begin);
        return result;
    }
}
