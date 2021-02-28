package com.graphqljava.tutorial.bookdetails.dataLoaders;

import org.dataloader.MappedBatchLoader;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutorService;

public abstract class AsyncMappedBatchLoader<K, V> implements MappedBatchLoader<K, V> {

    final ExecutorService executorService;

    public AsyncMappedBatchLoader(final ExecutorService executorService) {
        this.executorService = executorService;
    }

    abstract Map<K, V> asyncLoad(Set<K> keys);

    public CompletionStage<Map<K, V>> load(final Set<K> keys) {
        return CompletableFuture.supplyAsync(() -> asyncLoad(keys), executorService);
    }

}
