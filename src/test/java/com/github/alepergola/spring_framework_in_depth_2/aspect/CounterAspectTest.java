package com.github.alepergola.spring_framework_in_depth_2.aspect;

import com.github.alepergola.spring_framework_in_depth_2.service.CounterService;
import com.github.alepergola.spring_framework_in_depth_2.config.ApplicationConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ApplicationConfiguration.class})
public class CounterAspectTest {

    private final CounterAspect counterAspect;
    private final CounterService counterService;

    public CounterAspectTest() {
        counterService = new CounterService();

        counterAspect = new CounterAspect(counterService);
    }

    @Test
    void test() {
        assertNotNull(counterAspect);
    }

}
