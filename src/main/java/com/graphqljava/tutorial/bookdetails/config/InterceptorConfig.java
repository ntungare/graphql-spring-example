package com.graphqljava.tutorial.bookdetails.config;

import com.graphqljava.tutorial.bookdetails.interceptors.BoolInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Nonnull;

@Configuration
public class InterceptorConfig {

    final BoolInterceptor boolInterceptor;

    public InterceptorConfig(final BoolInterceptor boolInterceptor) {
        this.boolInterceptor = boolInterceptor;
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(@Nonnull final InterceptorRegistry registry) {
                registry.addInterceptor(boolInterceptor);
            }
        };
    }

}
