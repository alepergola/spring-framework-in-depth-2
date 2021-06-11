package com.github.alepergola.spring_framework_in_depth_2.aspect;

import com.github.alepergola.spring_framework_in_depth_2.config.ApplicationConfiguration;
import com.github.alepergola.spring_framework_in_depth_2.service.CounterService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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

    private final TestClass testClass;
    private final CounterService counterService;

    @Autowired
    public CounterAspectTest(CounterService counterService) {
        this.counterService = counterService;
        this.testClass = new TestClass();
    }

    @Test
    void count_whenNoCall_return0() {
        assertEquals(0, counterService.get(METHOD_NAME_1));
        assertEquals(0, counterService.get(METHOD_NAME_2));
        assertEquals(0, counterService.get(METHOD_NAME_3));
    }

    @Test
    void count_whenCalledOnce_return1() {
        testClass.method1();
        assertEquals(1, counterService.get(METHOD_NAME_1));
    }

    @Test
    void count_whenCalledTwice_return2() {
        testClass.method2();
        testClass.method2();
        assertEquals(2, counterService.get(METHOD_NAME_2));
    }

    @Test
    void count_whenCalledOnceForDifferentMethodNames_return1ForEachMethodName() {
        testClass.method1();
        testClass.method2();
        testClass.method3();
        assertEquals(1, counterService.get(METHOD_NAME_1));
        assertEquals(1, counterService.get(METHOD_NAME_2));
        assertEquals(1, counterService.get(METHOD_NAME_3));
    }

    @Test
    void count_whenCalledMultipleTimesForDifferentMethodNames_returnDifferentValues() {
        testClass.method1();
        testClass.method2();
        testClass.method2();
        testClass.method3();
        testClass.method3();
        testClass.method3();
        assertEquals(1, counterService.get(METHOD_NAME_1));
        assertEquals(2, counterService.get(METHOD_NAME_2));
        assertEquals(3, counterService.get(METHOD_NAME_3));
    }

}
