package com.graphqljava.tutorial.bookdetails.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class AppThreadExecutorConfig {

    @Bean
    public ExecutorService asyncExecutorForRequests() {
        return Executors.newFixedThreadPool(4);
    }

    @Bean
    public ExecutorService asyncExecutorForExtraction() {
        return Executors.newFixedThreadPool(4);
    }

}