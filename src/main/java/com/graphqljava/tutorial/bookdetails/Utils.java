package com.graphqljava.tutorial.bookdetails;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Utils {

    private static final Logger LOG = LoggerFactory.getLogger(Utils.class);

    public static List<Map<String, String>> filterObjectsUsingIds(
            @Nonnull final List<String> ids,
            @Nonnull final List<Map<String, String>> objects
    ) {
        return objects
                .stream()
                .filter(object -> ids.contains(object.get("id")))
                .collect(Collectors.toList());
    }

    public static <T> CompletableFuture<T> handleFetchAsync(
            final Supplier<T> supplier,
            final ExecutorService executorService
    ) {
        return CompletableFuture.supplyAsync(() -> {
            LOG.info("Running supplier");

            return supplier.get();
        }, executorService);
    }

}
