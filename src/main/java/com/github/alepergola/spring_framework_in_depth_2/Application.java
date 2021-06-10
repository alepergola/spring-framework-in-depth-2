package com.github.alepergola.spring_framework_in_depth_2;

import com.github.alepergola.spring_framework_in_depth_2.config.ApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        System.out.println("Hello world!");
    }

}