package com.graphqljava.tutorial.bookdetails;

import com.google.common.collect.ImmutableList;
import graphql.execution.instrumentation.ChainedInstrumentation;
import graphql.execution.instrumentation.Instrumentation;
import graphql.execution.instrumentation.dataloader.DataLoaderDispatcherInstrumentation;
import graphql.execution.instrumentation.dataloader.DataLoaderDispatcherInstrumentationOptions;

import javax.annotation.Nonnull;
import java.util.List;

public class MultipleInstrumentations {

    @Nonnull
    private static Instrumentation dataLoaderInstrumentation() {

        final DataLoaderDispatcherInstrumentationOptions options =
                DataLoaderDispatcherInstrumentationOptions
                        .newOptions()
                        .includeStatistics(true);

        return new DataLoaderDispatcherInstrumentation(options);
    }

    @Nonnull
    public static ChainedInstrumentation makeChainedInstrumentation() {
        final List<Instrumentation> instrumentations = ImmutableList.<Instrumentation>builder()
                // .add(new FederatedTracingInstrumentation())
                .add(dataLoaderInstrumentation())
                .build();

        return new ChainedInstrumentation(instrumentations);
    }

}
