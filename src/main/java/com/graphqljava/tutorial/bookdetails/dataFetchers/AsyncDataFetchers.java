package com.graphqljava.tutorial.bookdetails.dataFetchers;

import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class AsyncDataFetchers {

    public static abstract class AsyncDataFetcherWithArgs<I, T> {

        final ExecutorService executorService;

        public AsyncDataFetcherWithArgs(
                final ExecutorService executorService
        ) {
            this.executorService = executorService;
        }

        public CompletableFuture<T> handleFetch(
                final I inputs,
                final DgsDataFetchingEnvironment dataFetchingEnvironment
        ) {
            return CompletableFuture.supplyAsync(() -> doFetch(inputs, dataFetchingEnvironment), executorService);
        }

        abstract T doFetch(
                final I inputs,
                final DgsDataFetchingEnvironment dataFetchingEnvironment
        );

    }

    public static abstract class AsyncDataFetcherWithoutArgs<T> {

        final ExecutorService executorService;

        public AsyncDataFetcherWithoutArgs(
                final ExecutorService executorService
        ) {
            this.executorService = executorService;
        }

        public CompletableFuture<T> handleFetch(
                final DgsDataFetchingEnvironment dataFetchingEnvironment
        ) {
            return CompletableFuture.supplyAsync(() -> doFetch(dataFetchingEnvironment), executorService);
        }

        abstract T doFetch(
                final DgsDataFetchingEnvironment dataFetchingEnvironment
        );

    }


}
