package com.graphqljava.tutorial.bookdetails.context;

import com.google.common.collect.ImmutableMap;
import com.netflix.graphql.dgs.context.DgsCustomContextBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class GraphQLContext implements DgsCustomContextBuilder<Map<String, String>> {

    @Override
    public Map<String, String> build() {
        return ImmutableMap.<String, String>builder()
                .put("something", "somethingElse")
                .put("elsewhere", "rightHere")
                .build();
    }

}
