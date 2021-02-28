package com.graphqljava.tutorial.bookdetails.dataFetchers;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.graphqljava.tutorial.bookdetails.DgsConstants;
import com.graphqljava.tutorial.bookdetails.Utils;
import com.graphqljava.tutorial.bookdetails.dataFetchers.AsyncDataFetchers.AsyncDataFetcherWithoutArgs;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.context.DgsContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@DgsComponent
public class CharacterFetcher extends AsyncDataFetcherWithoutArgs<List<Map<String, String>>> {

    private static final Logger LOG = LoggerFactory.getLogger(CharacterFetcher.class);

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

    public CharacterFetcher(
            final ExecutorService executorService
    ) {
        super(executorService);
    }

    private static final Map<String, List<String>> bookToCharacterIds = ImmutableMap.of(
            "book-1", ImmutableList.of("character-1", "character-2"),
            "book-2", ImmutableList.of("character-2", "character-3"),
            "book-3", ImmutableList.of("character-1", "character-3")
    );

    private List<Map<String, String>> getCharactersForBook(final String bookId) {
        return Utils.filterObjectsUsingIds(bookToCharacterIds.get(bookId), characters);
    }

    @DgsData(parentType = DgsConstants.BOOK.TYPE_NAME, field = DgsConstants.BOOK.Characters)
    public CompletableFuture<List<Map<String, String>>> fetchCharactersForBook(
            @Nonnull final DgsDataFetchingEnvironment dataFetchingEnvironment
    ) {
        return handleFetch(dataFetchingEnvironment);
    }

    public List<Map<String, String>> doFetch(
            @Nonnull final DgsDataFetchingEnvironment dataFetchingEnvironment
    ) {
        final Map<String, String> book = dataFetchingEnvironment.getSource();
        final String bookId = book.get("id");
        final Map<String, String> context = DgsContext.getCustomContext(dataFetchingEnvironment);
        LOG.info("Fetching author for bookId {}", bookId);
        return getCharactersForBook(bookId);
    }

}
