package com.graphqljava.tutorial.bookdetails.dataFetchers;

import com.graphqljava.tutorial.bookdetails.DgsConstants;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import graphql.schema.DataFetchingEnvironment;
import org.dataloader.DataLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@DgsComponent
public class BookFetcher {

    private static final Logger LOG = LoggerFactory.getLogger(BookFetcher.class);

    @DgsData(parentType = DgsConstants.QUERY.TYPE_NAME, field = DgsConstants.QUERY.BookById)
    public CompletableFuture<Map<String, String>> fetchBookById(
            @Nonnull @InputArgument("id") final String bookId,
            @Nonnull final DataFetchingEnvironment dataFetchingEnvironment
    ) {
        final DataLoader<String, Map<String, String>> dataLoader = dataFetchingEnvironment
                .getDataLoader("books");
        LOG.info("Fetching author for bookId {}", bookId);
        return dataLoader.load(bookId);
    }

}
