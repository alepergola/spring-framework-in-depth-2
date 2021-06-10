package com.github.alepergola.spring_framework_in_depth_2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.github.alepergola.spring_framework_in_depth_2")
@EnableAspectJAutoProxy
public class ApplicationConfiguration {
}
