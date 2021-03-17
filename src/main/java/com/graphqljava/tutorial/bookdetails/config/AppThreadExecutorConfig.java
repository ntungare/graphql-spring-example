package com.graphqljava.tutorial.bookdetails.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class AppThreadExecutorConfig {

    final int availableProcessors = Runtime.getRuntime().availableProcessors();

    @Bean
    public ExecutorService executorService() {
        return Executors.newFixedThreadPool(availableProcessors);
    }

}