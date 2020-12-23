package com.graphqljava.tutorial.bookdetails;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import graphql.GraphQL;
import graphql.execution.AsyncExecutionStrategy;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.net.URL;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Component
public class GraphQLProvider {

    private final GraphQLDataFetchers graphQLDataFetchers;

    public GraphQLProvider(final GraphQLDataFetchers graphQLDataFetchers) {
        this.graphQLDataFetchers = graphQLDataFetchers;
    }

    @Bean
    public GraphQL graphQL() throws IOException {
        return generateGraphQLSchema();
    }

    public GraphQL generateGraphQLSchema() throws IOException {
        @SuppressWarnings("UnstableApiUsage") final URL url = Resources.getResource("schema.graphql");

        @SuppressWarnings("UnstableApiUsage") final String sdl = Resources.toString(url, Charsets.UTF_8);

        final GraphQLSchema graphQLSchema = buildSchema(sdl);

        return GraphQL.newGraphQL(graphQLSchema)
                // have to wait for the next version
                .instrumentation(MultipleInstrumentations.makeChainedInstrumentation())
                .queryExecutionStrategy(new AsyncExecutionStrategy())
                .build();
    }

    @Nonnull
    private GraphQLSchema buildSchema(String sdl) {
        final TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
        final RuntimeWiring runtimeWiring = buildWiring();
        final SchemaGenerator schemaGenerator = new SchemaGenerator();

        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(newTypeWiring("Query")
                        .dataFetcher("bookById", graphQLDataFetchers.getBookByIdDataFetcher()))
                .type(newTypeWiring("Book")
                        .dataFetcher("author", graphQLDataFetchers.getAuthorDataFetcher()))
                .type(newTypeWiring("Book")
                        .dataFetcher("characters", graphQLDataFetchers.getCharacterDataFetcher()))
                .build();
    }

}
