package com.github.alepergola.spring_framework_in_depth_2.aspect;

import com.github.alepergola.spring_framework_in_depth_2.annotation.Counter;
import com.github.alepergola.spring_framework_in_depth_2.config.ApplicationConfiguration;
import com.github.alepergola.spring_framework_in_depth_2.service.CounterService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ApplicationConfiguration.class})
public class CounterAspectTest {

    private static final String METHOD_NAME_1 = "method1";
    private static final String METHOD_NAME_2 = "method2";
    private static final String METHOD_NAME_3 = "method3";

    private final AspectTestClass aspectTestClass;
    private final CounterService counterService;

    @Autowired
    public CounterAspectTest(CounterService counterService) {
        this.counterService = counterService;
        this.aspectTestClass = new AspectTestClass();
    }

    @Test
    void count_whenNoCall_return0() {
        assertEquals(0, counterService.get(METHOD_NAME_1));
        assertEquals(0, counterService.get(METHOD_NAME_2));
        assertEquals(0, counterService.get(METHOD_NAME_3));
    }

    @Test
    void count_whenCalledOnce_return1() {
        aspectTestClass.method1();
        assertEquals(1, counterService.get(METHOD_NAME_1));
    }

    @Test
    void count_whenCalledTwice_return2() {
        aspectTestClass.method2();
        aspectTestClass.method2();
        assertEquals(2, counterService.get(METHOD_NAME_2));
    }

    @Test
    void count_whenCalledOnceForDifferentMethodNames_return1ForEachMethodName() {
        aspectTestClass.method1();
        aspectTestClass.method2();
        aspectTestClass.method3();
        assertEquals(1, counterService.get(METHOD_NAME_1));
        assertEquals(1, counterService.get(METHOD_NAME_2));
        assertEquals(1, counterService.get(METHOD_NAME_3));
    }

    @Test
    void count_whenCalledMultipleTimesForDifferentMethodNames_returnDifferentValues() {
        aspectTestClass.method1();
        aspectTestClass.method2();
        aspectTestClass.method2();
        aspectTestClass.method3();
        aspectTestClass.method3();
        aspectTestClass.method3();
        assertEquals(1, counterService.get(METHOD_NAME_1));
        assertEquals(2, counterService.get(METHOD_NAME_2));
        assertEquals(3, counterService.get(METHOD_NAME_3));
    }

    private static class AspectTestClass {

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

}
