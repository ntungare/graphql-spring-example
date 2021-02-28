package com.graphqljava.tutorial.bookdetails.dataFetchers;

import com.google.common.collect.ImmutableMap;
import com.graphqljava.tutorial.bookdetails.DgsConstants;
import com.graphqljava.tutorial.bookdetails.dataFetchers.AsyncDataFetchers.AsyncDataFetcherWithArgs;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.InputArgument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@DgsComponent
public class AuthorByIdFetcher extends AsyncDataFetcherWithArgs<String, Map<String, String>> {

    private static final Logger LOG = LoggerFactory.getLogger(AuthorByIdFetcher.class);

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

    public AuthorByIdFetcher(
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

    @DgsData(parentType = DgsConstants.QUERY.TYPE_NAME, field = DgsConstants.QUERY.AuthorById)
    public CompletableFuture<Map<String, String>> fetchAuthorForBook(
            @Nonnull @InputArgument("id") final String authorId,
            @Nonnull final DgsDataFetchingEnvironment dataFetchingEnvironment
    ) {
        LOG.info("Handling fetch for author for authorId {}", authorId);
        return handleFetch(authorId, dataFetchingEnvironment);
    }

    public Map<String, String> doFetch(
            @Nonnull @InputArgument("id") final String authorId,
            @Nonnull final DgsDataFetchingEnvironment dataFetchingEnvironment
    ) {
        LOG.info("Fetching author for authorId {}", authorId);
        return getAuthorById(authorId);
    }

}
