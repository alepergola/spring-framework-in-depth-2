package com.github.alepergola.spring_framework_in_depth_2.aspect;

import com.github.alepergola.spring_framework_in_depth_2.annotation.Counter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
class TestClass {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Counter
    void method1() {
        logger.info("Called method 1");
    }

    @Counter
    void method2() {
        logger.info("Called method 2");
    }

    @Counter
    void method3() {
        logger.info("Called method 3");
    }

}
