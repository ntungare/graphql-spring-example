package com.graphqljava.tutorial.bookdetails;

import org.dataloader.BatchLoader;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Registry {

    @Bean
    public DataLoaderRegistry dataLoaderRegistry(final GraphQLDataFetchers graphQLDataFetchers) {

        final DataLoaderRegistry registry = new DataLoaderRegistry();

        final BatchLoader<String, Map<String, String>> authorBatchLoader =
                graphQLDataFetchers.authorBatchLoader();
        final DataLoader<String, Map<String, String>> authorDataLoader =
                DataLoader.newDataLoader(authorBatchLoader);

        final BatchLoader<String, Map<String, String>> characterBatchLoader =
                graphQLDataFetchers.characterBatchLoader();
        final DataLoader<String, Map<String, String>> characterDataLoader =
                DataLoader.newDataLoader(characterBatchLoader);

        registry.register("author", authorDataLoader);
        registry.register("character", characterDataLoader);

        return registry;
    }
}
