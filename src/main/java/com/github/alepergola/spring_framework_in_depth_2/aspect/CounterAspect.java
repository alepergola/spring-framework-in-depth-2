package com.github.alepergola.spring_framework_in_depth_2.aspect;

import com.github.alepergola.spring_framework_in_depth_2.service.CounterService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CounterAspect {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final CounterService counterService;

    public CounterAspect(CounterService counterService) {
        this.counterService = counterService;
    }

    @Pointcut("@annotation(Counter)")
    public void countMethodCall() {
    }

    @Before("countMethodCall()")
    public void countMethodCall(JoinPoint pointcut) {
        String methodName = pointcut.getTarget().toString();
        int methodCallCount = counterService.count(methodName);

        logger.info("{} : {}", methodName, methodCallCount);
    }

}
