package com.swaraj.projectx.streams;

import com.swaraj.projectx.cars.ConcreteCar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Customer {
    private String name;
    private String email;
    private List<String> phoneNumbers;
}

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
    void intStreamTest() {
        IntStream range = IntStream.range(1, 21);
        range.forEach(value -> System.out.println("value = " + value));

        IntStream.range(1, 100).limit(50)
                .forEach(value -> System.out.println("value = " + value));
    }

    @Test
    void generateConcreteCars() {
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

    @Test
    void stream_initialization() {
        Map<Integer, String> integerStringMap = Map.of(123, "123", 124, "124");
        integerStringMap.forEach((key, value) -> {
            System.out.println("key = " + key + " value = " + value);
        });
    }

    @Test
    void filter_test() {
        List<String> names = List.of("one", "two", "eleven", "thirty", "elephant");
        names.stream()
                .filter(name -> name.startsWith("e"))
                .forEach(filteredName -> {
                    System.out.println("filteredName = " + filteredName);
                });
    }

    @Test
    void test_map_stream() {
        //use map function for one-to-one mapping, i.e. each customer has one name
        List<String> customerNames = getCustomers().stream()
                .map(cust -> cust.getName())
                .collect(Collectors.toList());
        customerNames.forEach(cust -> System.out.println("cust = " + cust));
    }

    @Test
    void test_flat_map_stream() {
        // use flatMap for one-to-many mapping i.e. each cust has many phone numbers
        List<String> allCustomerPhoneNumbers = getCustomers().stream()
                .flatMap(customer -> customer.getPhoneNumbers().stream())
                .collect(Collectors.toList());
        for (String allCustomerPhoneNumber : allCustomerPhoneNumbers) {
            System.out.println("allCustomerPhoneNumber = " + allCustomerPhoneNumber);
        }
    }

    @Test
    void optional_usage() {
        Customer customer = new Customer("dummy", "test@gmail.com", List.of("phone1", "phone2"));
        Optional<String> stringOptional = Optional.empty();
        System.out.println("stringOptional = " + stringOptional);

        //Optional<Object> o = Optional.of(null); // will throw null pointer exception
        Optional<String> emailOptional = Optional.ofNullable(customer.getEmail()); // will not throw null pointer
        System.out.println(emailOptional.orElse("dummy-email@email.com"));

//        assertThrows(IllegalArgumentException.class,
//                () -> {
//                    String s = emailOptional.orElseThrow(() -> new IllegalArgumentException("email required"));
//                });
        String s1 = emailOptional.map(s -> s.toUpperCase()).orElseGet(() -> "INVALID");
        System.out.println("s1 = " + s1);
    }

    @Test
    void filter_stream_and_get_default() {
        Customer customer = getCustomers().stream().
                filter(c -> c.getEmail().equalsIgnoreCase("non-exist@gmail.com")).
                findAny().
                orElseGet(() -> new Customer("default", "default.email@com", List.of("default", "xxx")));
        System.out.println("customer = " + customer);
    }

    @Test
    void test_stream_reduce() {
        List<Integer> numbers = Arrays.asList(3, 7, 8, 1, 5, 9);
        //numbers.sort((o1, o2) -> Integer.compare(o1, o2)); // default, sort in increasing order
        numbers.sort((o1, o2) -> Integer.compare(o2, o1)); // sort in decreasing order
        numbers.forEach(i -> System.out.println("i = " + i));

        Integer sumOfNumbers = numbers.stream()
                .reduce(0, (integer, integer2) -> integer + integer2);
        System.out.println("sumOfNumbers = " + sumOfNumbers);
        int sumUsingIntStream = numbers.stream().mapToInt(i -> i).sum();
        assertEquals(sumOfNumbers, sumUsingIntStream);

        //with method reference, concept remains the same
        int sum3 = numbers.stream().reduce(0, Integer::sum);
        assertEquals(sumOfNumbers, sum3);
    }

    @Test
    void test_reduce_with_string() {
        //find word with longest characters
        List<String> words = Arrays.asList("corejava", "hibernate", "spring");
        Optional<String> longestWord = words.stream()
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2);
        System.out.println("longestWord.get() = " + longestWord.get());
    }

    @Test
    void stream_exception_handling(){
        List<String> numbers= Arrays.asList("1","2","3x");
//        List<Integer> integers = numbers.stream()
//                .map(StreamTests::myExceptionHandling)
//                .collect(Collectors.toList());
//        integers.forEach(integer -> System.out.println(integer));
        numbers.forEach(acceptAndCheck(s -> System.out.println(Integer.parseInt(s))));
    }

    private static Consumer<String> acceptAndCheck(Consumer<String> input) {
        return str -> {
            try {
                input.accept(str);
            } catch (Exception e) {
                System.out.println("e = " + e.getMessage());
            }
        };
    }

    private static int myExceptionHandling(String value) {
        int i = -1;
        try {
            i = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        return i;
    }

    private List<Customer> getCustomers() {
        return Stream.of(
                new Customer("name1", "name1@gmail.com", List.of("nam1-phone1", "name1-phone2")),
                new Customer("name2", "name2@gmail.com", List.of("nam2-phone1", "name2-phone2")),
                new Customer("name3", "name3@gmail.com", List.of("nam3-phone1", "name3-phone2")),
                new Customer("name4", "name4@gmail.com", List.of("nam4-phone1", "name4-phone2"))
        ).collect(Collectors.toList());
    }
}
