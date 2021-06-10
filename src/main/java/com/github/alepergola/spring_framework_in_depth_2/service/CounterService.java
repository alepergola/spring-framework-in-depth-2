package com.github.alepergola.spring_framework_in_depth_2.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CounterService {

    private final HashMap<String, Integer> methodMap;

    public CounterService() {
        this.methodMap = new HashMap<>();
    }

    public Integer count(String methodName) {
        int methodCount = methodMap.getOrDefault(methodName, 0);
        methodCount++;
        return methodMap.put(methodName, methodCount);
    }


}
