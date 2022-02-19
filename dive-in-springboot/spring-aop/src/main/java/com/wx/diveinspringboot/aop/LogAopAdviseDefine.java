package com.wx.diveinspringboot.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @program: deep-in-springboot
 * @description:
 * @author: Mr.Wang
 * @create: 2021-10-12 22:03
 **/
@Component
@Aspect
@Slf4j
public class LogAopAdviseDefine {

    @Pointcut("within(com.wx.diveinspringboot.service.NeedLogService)")
    public void pointcut(){

    }

    @Before("pointcut()")
    public void recordParm(JoinPoint joinPoint){
        log.info("---Before method {} invoke, param: {}---",
                joinPoint.getSignature().toShortString(), joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "pointcut()", returning = "retVal")
    public void logMethodInvokeResult(JoinPoint joinPoint, Object retVal){
        log.info("---After method {} invoke, result: {}---", joinPoint.getSignature().toShortString(),joinPoint.getArgs());
    }

    @AfterThrowing(pointcut = "pointcut()", throwing = "exception")
    public void logMethodInvokeException(JoinPoint joinPoint, Exception exception) {
        log.info("---method {} invoke exception: {}---", joinPoint.getSignature().toShortString(), exception.getMessage());
    }

}
