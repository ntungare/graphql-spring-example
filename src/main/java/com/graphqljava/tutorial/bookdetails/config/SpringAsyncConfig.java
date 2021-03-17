package com.graphqljava.tutorial.bookdetails.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

@Configuration
@EnableAsync
public class SpringAsyncConfig {

    final ExecutorService executorService;

    public SpringAsyncConfig(final ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Bean
    public Executor threadPoolTaskExecutor() {
        return executorService;
    }

}