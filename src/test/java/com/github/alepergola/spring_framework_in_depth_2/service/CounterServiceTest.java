package com.github.alepergola.spring_framework_in_depth_2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CounterServiceTest {

    private static final String METHOD_NAME_1 = "METHOD_NAME_1";
    private static final String METHOD_NAME_2 = "METHOD_NAME_2";
    private static final String METHOD_NAME_3 = "METHOD_NAME_3";

    private CounterService counterService;

    @BeforeEach
    void setup() {
        counterService = new CounterService();
    }

    @Test
    void get_whenNoCall_return0() {
        assertEquals(0, counterService.get(METHOD_NAME_3));
    }

    @Test
    void get_whenOneCall_return1() {
        counterService.count(METHOD_NAME_2);
        assertEquals(1, counterService.get(METHOD_NAME_2));
    }

    @Test
    void reset_whenNoCall_return0() {
        counterService.reset();
        assertEquals(0, counterService.get(METHOD_NAME_1));
        assertEquals(0, counterService.get(METHOD_NAME_2));
        assertEquals(0, counterService.get(METHOD_NAME_3));
    }

    @Test
    void reset_whenOneCall_return1() {
        counterService.count(METHOD_NAME_2);
        counterService.reset();
        assertEquals(0, counterService.get(METHOD_NAME_1));
        assertEquals(0, counterService.get(METHOD_NAME_2));
        assertEquals(0, counterService.get(METHOD_NAME_3));
    }

    @Test
    void reset_whenMultipleCall_return0() {
        counterService.count(METHOD_NAME_1);
        counterService.count(METHOD_NAME_2);
        counterService.count(METHOD_NAME_2);
        counterService.count(METHOD_NAME_3);
        counterService.count(METHOD_NAME_3);
        counterService.count(METHOD_NAME_3);
        counterService.reset();
        assertEquals(0, counterService.get(METHOD_NAME_1));
        assertEquals(0, counterService.get(METHOD_NAME_2));
        assertEquals(0, counterService.get(METHOD_NAME_3));
    }

    @Test
    void count_whenCalledWithNull_return1() {
        int count = counterService.count(null);
        assertEquals(1, count);
    }

    @Test
    void count_whenCalledOnce_return1() {
        int count = counterService.count(METHOD_NAME_1);
        assertEquals(1, count);
    }

    @Test
    void count_whenCalledTwice_return2() {
        counterService.count(METHOD_NAME_2);
        int count = counterService.count(METHOD_NAME_2);
        assertEquals(2, count);
    }

    @Test
    void count_whenCalledOnceForDifferentMethodNames_return1ForEachMethodName() {
        int count1 = counterService.count(METHOD_NAME_1);
        int count2 = counterService.count(METHOD_NAME_2);
        int count3 = counterService.count(METHOD_NAME_3);
        assertEquals(1, count1);
        assertEquals(1, count2);
        assertEquals(1, count3);
    }

    @Test
    void count_whenCalledMultipleTimesForDifferentMethodNames_returnDifferentValues() {
        int count1 = counterService.count(METHOD_NAME_1);
        counterService.count(METHOD_NAME_2);
        int count2 = counterService.count(METHOD_NAME_2);
        counterService.count(METHOD_NAME_3);
        counterService.count(METHOD_NAME_3);
        int count3 = counterService.count(METHOD_NAME_3);
        assertEquals(1, count1);
        assertEquals(2, count2);
        assertEquals(3, count3);
    }

}
