package com.graphqljava.tutorial.bookdetails.dataFetchers;

import java.util.concurrent.ExecutorService;
import java.util.function.Supplier;

public class AsyncDataFetchers<T> {

    final ExecutorService executorService;

    public AsyncDataFetchers(final ExecutorService executorService) {
        this.executorService = executorService;
    }

    public T handleFetch(final Supplier<T> supplier) {
        return supplier.get();
    }

}
