package com.example.playground.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggerAspect {

  @Around("@annotation(com.example.playground.aop.annotation.MyLogger)")
  public Object myLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    long start = System.currentTimeMillis();

    Object res = proceedingJoinPoint.proceed();

    long end = System.currentTimeMillis();
    System.out.println("Time took: " + (end - start));
    return res;

  }
}
