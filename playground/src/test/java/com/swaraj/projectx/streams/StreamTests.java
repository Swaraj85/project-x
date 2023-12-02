package com.swaraj.projectx.streams;

import com.swaraj.projectx.cars.ConcreteCar;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamTests {
    private final static Collection<ConcreteCar> concreteCars;

    static {
        concreteCars = new ArrayList<>();
        concreteCars.add(new ConcreteCar("tata", 12));
        concreteCars.add(new ConcreteCar("volks", 2));
        concreteCars.add(new ConcreteCar("nissan", 23));
    }

    @Test
    void testLambda() {
        BiFunction<String, String, Integer> holder = (s, s2) -> Integer.parseInt(s + s2);
        assertEquals(12, funcManager("1", "2", holder));
    }

    @Test
    void streamMapTests() {
        List<Integer> collect = concreteCars.stream().map(c -> c.hashCode())
                .collect(Collectors.toList());
        collect.forEach(c -> System.out.println("c = " + c));

        try (Stream<String> stringStreams = Stream.of("1", "2", "3")) {
            List<String> collect1 = stringStreams.filter(s -> s.equalsIgnoreCase("2"))
                    .collect(Collectors.toList());
            assertEquals("2", collect1.stream().findFirst().get());
        }
    }

    @Test
    void intStreamTest(){
        IntStream range = IntStream.range(1, 21);
        range.forEach(value -> System.out.println("value = " + value));

        IntStream.range(1, 100).limit(50)
                .forEach(value -> System.out.println("value = " + value));
    }

    @Test
    void generateConcreteCars(){
        List<ConcreteCar> collect = IntStream.rangeClosed(1, 100)
                .mapToObj(value -> new ConcreteCar("name" + value, value))
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    @Test
    void stringStreamGroupingTest() {
        Set<Map.Entry<String, Long>> entries = Stream.of("apple", "orange", "banana", "apple").
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet();
        entries.forEach(System.out::println);
    }

    private int funcManager(String data1, String data2, BiFunction<String, String, Integer> injectedBehaviour) {
        Integer apply = injectedBehaviour.apply(data1, data2);
        return apply;
    }
}
