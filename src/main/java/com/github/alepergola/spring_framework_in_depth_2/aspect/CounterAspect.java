package com.github.alepergola.spring_framework_in_depth_2.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CounterAspect {


    @Pointcut("@annotation(Counter)")
    public void countMethodCall() {
    }

    @Before("countMethodCall()")
    public void countMethodCall(JoinPoint pointcut) {
        System.out.println("Hello AspectJ!");
    }

}
