package com.graphqljava.tutorial.bookdetails;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.spring.web.servlet.GraphQLInvocation;
import graphql.spring.web.servlet.GraphQLInvocationData;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Primary
@Component
public class Invocation implements GraphQLInvocation {

    private static final Logger log = LoggerFactory.getLogger(Invocation.class);

    private final GraphQL graphQL;

    private final DataLoaderRegistry dataLoaderRegistry;

    public Invocation(final GraphQL graphQL, final DataLoaderRegistry dataLoaderRegistry) {
        this.graphQL = graphQL;
        this.dataLoaderRegistry = dataLoaderRegistry;
    }

    @Override
    public CompletableFuture<ExecutionResult> invoke(
            @Nonnull final GraphQLInvocationData invocationData,
            @Nonnull final WebRequest webRequest
    ) {
        final ExecutionInput executionInput = new ExecutionInput.Builder()
                .query(invocationData.getQuery())
                .operationName(invocationData.getOperationName())
                .variables(invocationData.getVariables())
                .dataLoaderRegistry(dataLoaderRegistry)
                .build();

        final CompletableFuture<Map<String, String>> author = getAuthor();
        final CompletableFuture<Map<String, String>> character = getCharacter();
        final CompletableFuture<List<Map<String, String>>> authors = getAuthors();
        final CompletableFuture<List<Map<String, String>>> characters = getCharacters();

        final Map<String, Map<String, String>> singularResults = getMapOfResultsWithSingularResults(
                ImmutableMap.<String, CompletableFuture<Map<String, String>>>builder()
                        .put("author", author)
                        .put("character", character)
                        .build()
        );

        final Map<String, List<Map<String, String>>> multipleResults = getMapOfResultsWithMultipleResults(
                ImmutableMap.<String, CompletableFuture<List<Map<String, String>>>>builder()
                        .put("authors", authors)
                        .put("characters", characters)
                        .build()
        );

        log.info(singularResults.get("author").toString());
        log.info(singularResults.get("character").toString());

        log.info(multipleResults.get("authors").toString());
        log.info(multipleResults.get("characters").toString());

        return graphQL.executeAsync(executionInput);
    }

    public CompletableFuture<Map<String, String>> getAuthor() {
        final DataLoader<String, Map<String, String>> authorDataLoader =
                dataLoaderRegistry.getDataLoader("author");

        return getFromDataLoader(authorDataLoader, "author-3");
    }

    public CompletableFuture<Map<String, String>> getCharacter() {
        final DataLoader<String, Map<String, String>> characterDataLoader =
                dataLoaderRegistry.getDataLoader("character");

        return getFromDataLoader(characterDataLoader, "character-1");
    }

    public CompletableFuture<List<Map<String, String>>> getAuthors() {
        final DataLoader<String, Map<String, String>> authorDataLoader =
                dataLoaderRegistry.getDataLoader("author");

        return getFromDataLoader(authorDataLoader, ImmutableList.of("author-3", "author-2"));
    }

    public CompletableFuture<List<Map<String, String>>> getCharacters() {
        final DataLoader<String, Map<String, String>> characterDataLoader =
                dataLoaderRegistry.getDataLoader("character");

        return getFromDataLoader(characterDataLoader, ImmutableList.of("character-1", "character-2"));
    }

    @Nonnull
    private CompletableFuture<Map<String, String>> getFromDataLoader(
            @Nonnull final DataLoader<String, Map<String, String>> dataLoader,
            @Nonnull final String dataKey
    ) {
        return dataLoader.load(dataKey);
    }

    @Nonnull
    private CompletableFuture<List<Map<String, String>>> getFromDataLoader(
            @Nonnull final DataLoader<String, Map<String, String>> dataLoader,
            @Nonnull final List<String> dataKeys
    ) {
        return dataLoader.loadMany(dataKeys);
    }

    @Nonnull
    private Map<String, List<Map<String, String>>> getMapOfResultsWithMultipleResults(
            @Nonnull final Map<String, CompletableFuture<List<Map<String, String>>>> possibleResults
    ) {
        dataLoaderRegistry.dispatchAll();

        final Map<String, List<Map<String, String>>> results = new HashMap<>();

        possibleResults.forEach((key, possibleResult) -> {
            try {
                results.put(key, ImmutableList.copyOf(possibleResult.get()));
            } catch (final InterruptedException | ExecutionException exception) {
                results.put(key, Collections.emptyList());
            }
        });

        return results;
    }

    @Nonnull
    private Map<String, Map<String, String>> getMapOfResultsWithSingularResults(
            @Nonnull final Map<String, CompletableFuture<Map<String, String>>> possibleResults
    ) {
        dataLoaderRegistry.dispatchAll();

        final Map<String, Map<String, String>> results = new HashMap<>();

        possibleResults.forEach((key, possibleResult) -> {
            try {
                results.put(key, ImmutableMap.copyOf(possibleResult.get()));
            } catch (final InterruptedException | ExecutionException exception) {
                results.put(key, Collections.emptyMap());
            }
        });

        return results;
    }

}
