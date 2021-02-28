package com.graphqljava.tutorial.bookdetails.dataFetchers;

import com.google.common.collect.ImmutableMap;
import com.graphqljava.tutorial.bookdetails.DgsConstants;
import com.graphqljava.tutorial.bookdetails.dataFetchers.AsyncDataFetchers.AsyncDataFetcherWithoutArgs;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@DgsComponent
public class AuthorFromBookFetcher extends AsyncDataFetcherWithoutArgs<Map<String, String>> {

    private static final Logger LOG = LoggerFactory.getLogger(AuthorFromBookFetcher.class);

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

    public AuthorFromBookFetcher(
            final ExecutorService executorService
    ) {
        super(executorService);
    }

    private static Map<String, String> getAuthorById(final String authorId) {
        return authors
                .stream()
                .filter(author -> author.get("id").equals(authorId))
                .findFirst()
                .orElse(null);
    }

    @DgsData(parentType = DgsConstants.BOOK.TYPE_NAME, field = DgsConstants.BOOK.Author)
    public CompletableFuture<Map<String, String>> fetchAuthorForBook(
            @Nonnull final DgsDataFetchingEnvironment dataFetchingEnvironment
    ) {
        return handleFetch(dataFetchingEnvironment);
    }

    public Map<String, String> doFetch(
            @Nonnull final DgsDataFetchingEnvironment dataFetchingEnvironment
    ) {
        final Map<String, String> book = dataFetchingEnvironment.getSource();
        final String authorId = book.get("authorId");
        LOG.info("Fetching author for book with authorId {}", authorId);
        return getAuthorById(authorId);
    }

}
