package com.github.alepergola.spring_framework_in_depth_2.config;

import com.github.alepergola.spring_framework_in_depth_2.Application;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackageClasses = Application.class)
@EnableAspectJAutoProxy
public class ApplicationConfiguration {
}
