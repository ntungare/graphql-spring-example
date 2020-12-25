package com.graphqljava.tutorial.bookdetails;

import org.dataloader.BatchLoader;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import java.util.Map;

@Component
public class Registry {

    @Bean
    @Nonnull
    public DataLoader<String, Map<String, String>> authorDataLoader(
            @Nonnull final GraphQLDataFetchers graphQLDataFetchers
    ) {
        final BatchLoader<String, Map<String, String>> authorBatchLoader =
                graphQLDataFetchers.authorBatchLoader();

        return DataLoader.newDataLoader(authorBatchLoader);
    }

    @Bean
    @Nonnull
    public DataLoader<String, Map<String, String>> characterDataLoader(
            @Nonnull final GraphQLDataFetchers graphQLDataFetchers
    ) {
        final BatchLoader<String, Map<String, String>> characterBatchLoader =
                graphQLDataFetchers.characterBatchLoader();

        return DataLoader.newDataLoader(characterBatchLoader);
    }

    @Bean
    public DataLoaderRegistry dataLoaderRegistry(
            final DataLoader<String, Map<String, String>> authorDataLoader,
            final DataLoader<String, Map<String, String>> characterDataLoader
    ) {
        final DataLoaderRegistry registry = new DataLoaderRegistry();

        registry.register("author", authorDataLoader);
        registry.register("character", characterDataLoader);

        return registry;
    }

}
