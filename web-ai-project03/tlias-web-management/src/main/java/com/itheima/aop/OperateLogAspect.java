package com.itheima.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.mapper.OperateLogMapper;
import com.itheima.pojo.OperateLog;
import com.itheima.utils.CurrentHolder;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.aop.support.AopUtils;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class OperateLogAspect {

    private final OperateLogMapper operateLogMapper;

    public OperateLogAspect(OperateLogMapper operateLogMapper) {
        this.operateLogMapper = operateLogMapper;
    }

    // 1. 定义切入点：拦截 controller 包及其子包中的所有方法
    @Pointcut("@annotation(com.itheima.anno.Log)")
    public void pt() {
    }

    // 2. 环绕通知
    @Around("pt()")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {


        // 记录方法开始执行的时间
        long begin = System.currentTimeMillis();

        // 用于保存方法返回值
        Object result = null;

        try {
            // 3. 执行原始业务方法
            result = joinPoint.proceed();
            return result;

        } finally {

            // 4. 计算方法执行耗时
            long end = System.currentTimeMillis();
            long costTime = end - begin;

            // 5. 封装日志对象
            OperateLog operateLog = new OperateLog();

            // 操作人ID（从登录用户上下文中获取）
            operateLog.setOperateEmpId(getCurrentUserId());

            // 操作时间
            operateLog.setOperateTime(LocalDateTime.now());

            // 目标类全类名
            operateLog.setClassName(
                    AopUtils.getTargetClass(joinPoint.getTarget()).getName()
            );

            // 目标方法名
            operateLog.setMethodName(joinPoint.getSignature().getName());

            // 方法运行时参数，转成 JSON 字符串
            operateLog.setMethodParams(Arrays.toString(joinPoint.getArgs()));

            // 方法返回值，转成 JSON 字符串
            operateLog.setReturnValue(result != null ? result.toString():"void");

            // 方法执行耗时
            operateLog.setCostTime(costTime);

            // 6. 保存日志
            operateLogMapper.insert(operateLog);

            log.info("操作日志已记录：{}，耗时：{}ms",
                    operateLog.getMethodName(), costTime);
        }
    }
    private Integer getCurrentUserId(){
        return CurrentHolder.getCurrentId();
    }

}