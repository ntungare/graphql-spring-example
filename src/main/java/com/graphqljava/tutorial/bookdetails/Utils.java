package com.graphqljava.tutorial.bookdetails;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Utils {

    public static List<Map<String, String>> filterObjectsUsingIds(
            @Nonnull final List<String> ids,
            @Nonnull final List<Map<String, String>> objects
    ) {
        return objects
                .stream()
                .filter(object -> ids.contains(object.get("id")))
                .collect(Collectors.toList());
    }

}
