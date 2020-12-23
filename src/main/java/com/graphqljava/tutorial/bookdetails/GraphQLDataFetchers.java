package com.graphqljava.tutorial.bookdetails;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import graphql.schema.DataFetcher;
import org.dataloader.BatchLoader;
import org.dataloader.DataLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Component
public class GraphQLDataFetchers {

    final static Logger log = LoggerFactory.getLogger(GraphQLDataFetchers.class);

    private static final List<Map<String, String>> books = Arrays.asList(
            ImmutableMap.of(
                    "id", "book-1",
                    "name", "Harry Potter and the Philosopher's Stone",
                    "pageCount", "223",
                    "authorId", "author-1"
            ),
            ImmutableMap.of(
                    "id", "book-2",
                    "name", "Moby Dick",
                    "pageCount", "635",
                    "authorId", "author-2"
            ),
            ImmutableMap.of(
                    "id", "book-3",
                    "name", "Interview with the vampire",
                    "pageCount", "371",
                    "authorId", "author-3"
            )
    );

    private static final List<Map<String, String>> authors = Arrays.asList(
            ImmutableMap.of(
                    "id", "author-1",
                    "firstName", "Joanne",
                    "lastName", "Rowling"
            ),
            ImmutableMap.of(
                    "id", "author-2",
                    "firstName", "Herman",
                    "lastName", "Melville"
            ),
            ImmutableMap.of(
                    "id", "author-3",
                    "firstName", "Anne",
                    "lastName", "Rice"
            )
    );

    private static final List<Map<String, String>> characters = Arrays.asList(
            ImmutableMap.of(
                    "id", "character-1",
                    "firstName", "Mob",
                    "lastName", "Riordan"
            ),
            ImmutableMap.of(
                    "id", "character-2",
                    "firstName", "Percy",
                    "lastName", "Seuss"
            ),
            ImmutableMap.of(
                    "id", "character-3",
                    "firstName", "Jane",
                    "lastName", "Austin"
            )
    );

    private static final Map<String, List<String>> bookToCharacterIds = ImmutableMap.of(
            "book-1", ImmutableList.of("character-1", "character-2"),
            "book-2", ImmutableList.of("character-2", "character-3"),
            "book-3", ImmutableList.of("character-1", "character-3")
    );

    public DataFetcher<Map<String, String>> getBookByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            final String bookId = dataFetchingEnvironment.getArgument("id");
            return books
                    .stream()
                    .filter(book -> book.get("id").equals(bookId))
                    .findFirst()
                    .orElse(null);
        };
    }

    public List<Map<String, String>> filterObjectsUsingIds(
            final List<String> ids, final List<Map<String, String>> objects
    ) {
        return objects
                .stream()
                .filter(object -> ids.contains(object.get("id")))
                .collect(Collectors.toList());

    }

    public BatchLoader<String, Map<String, String>> characterBatchLoader() {
        return characterIds -> {
            log.info(characterIds.toString());
            log.info(characterIds.getClass().getSimpleName());

            return CompletableFuture.supplyAsync(() -> filterObjectsUsingIds(characterIds, characters));
        };
    }

    public BatchLoader<String, Map<String, String>> authorBatchLoader() {
        return authorIds -> {
            log.info(authorIds.toString());
            log.info(authorIds.getClass().getSimpleName());

            return CompletableFuture.supplyAsync(() -> filterObjectsUsingIds(authorIds, authors));
        };
    }

    public DataFetcher<CompletableFuture<Map<String, String>>> getAuthorDataFetcher() {
        return dataFetchingEnvironment -> {
            final Map<String, String> book = dataFetchingEnvironment.getSource();
            final String authorId = book.get("authorId");
            final DataLoader<String, Map<String, String>> dataLoader =
                    dataFetchingEnvironment.getDataLoader("author");

            return dataLoader.load(authorId);
        };
    }

    public DataFetcher<CompletableFuture<List<Map<String, String>>>> getCharacterDataFetcher() {
        return dataFetchingEnvironment -> {
            final Map<String, String> book = dataFetchingEnvironment.getSource();
            final String bookId = book.get("id");
            final DataLoader<String, Map<String, String>> dataLoader =
                    dataFetchingEnvironment.getDataLoader("character");

            return dataLoader.loadMany(bookToCharacterIds.get(bookId));
        };
    }

}
