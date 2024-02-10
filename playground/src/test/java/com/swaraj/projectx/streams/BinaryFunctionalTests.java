package com.swaraj.projectx.streams;

import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BiFunctionalExample implements BiFunction<List<String>, List<String>, List<String>> {

    @Override
    public List<String> apply(List<String> firstList, List<String> secondList) {
        return Stream.of(firstList, secondList)
                .flatMap(s -> s.stream())
                .distinct()
                .collect(Collectors.toList());
    }
}

public class BinaryFunctionalTests {

    @Test
    void test_bifunction_example() {
        List<String> apply = new BiFunctionalExample()
                .apply(Arrays.asList("one", "two"), Arrays.asList("one", "two"));
        assertEquals(apply, Arrays.asList("one", "two"));
    }

    @Test
    void test_biFunction_lambda_way() {
        // merge two lists and produce distinct list of strings
        BiFunction<List<String>, List<String>, List<String>> applier = (list1, list2) -> {
            return Stream.of(list1, list2).flatMap(Collection::stream).
                    distinct().collect(Collectors.toList());
        };
        List<String> result = applier.apply(Arrays.asList("one", "two"), Arrays.asList("one", "two"));
        assertEquals(result, Arrays.asList("one", "two"));
    }
}
