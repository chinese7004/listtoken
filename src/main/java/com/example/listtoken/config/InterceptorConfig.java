package com.example.listtoken.config;

import com.example.listtoken.interceptor.UserAuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Huoshan
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Bean
    public UserAuthInterceptor userAuthInterceptor() {
        return new UserAuthInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userAuthInterceptor()).addPathPatterns("/**").excludePathPatterns("/", "/login", "/register", "/error", "/*.html");
    }
}
