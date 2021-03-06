package com.despegar.dasboot.config;

import com.despegar.dasboot.controller.interceptor.ContextInterceptor;
import com.despegar.dasboot.controller.interceptor.LoggingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MVCConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ContextInterceptor());
        registry.addInterceptor(new LoggingInterceptor());
    }
}
