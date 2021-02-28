package com.graphqljava.tutorial.bookdetails.dataLoaders;

import com.google.common.collect.ImmutableMap;
import com.netflix.graphql.dgs.DgsDataLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;

@DgsDataLoader(name = "books")
public class BookLoader extends AsyncMappedBatchLoader<String, Map<String, String>> {

    private static final Logger LOG = LoggerFactory.getLogger(BookLoader.class);

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

    public BookLoader(final ExecutorService executorService) {
        super(executorService);
    }

    @Override
    public Map<String, Map<String, String>> asyncLoad(final Set<String> bookIds) {
        LOG.info("Loading books for bookIds {}", bookIds);
        return books.stream()
                .filter(book -> bookIds.contains(book.get("id")))
                .collect(
                        Collectors.toMap(
                                book -> book.get("id"),
                                book -> book
                        )
                );
    }

}
