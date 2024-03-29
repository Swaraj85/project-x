package com.swaraj.projectx.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BasicLambdaTests {

    @FunctionalInterface
    private interface SwarajInterface {
        default void printName() {
            System.out.println("\"SwarajInterface\" = " + "SwarajInterface");
        }

        static void doSomething() {
        }

        //void myApply();
        void sum(int x);
    }

    @Test
    void simple_lambda_expression() {
//        SwarajInterface inter = () -> {
//            System.out.println("calling from lambda");
//        };
//
//        inter.myApply();

        SwarajInterface inter = (int x) -> {
        };
        inter.sum(2);
    }

    @Test
    void test_sorting() {
        List<Book> booksList = IntStream.range(0, 10)
                .mapToObj(value -> new Book(String.valueOf(value), value)).
                collect(Collectors.toList());
        // sort in reverse order
        Collections.sort(booksList, (o1, o2) -> {
            return Integer.compare(o2.getIsbnNumber(), o1.getIsbnNumber());
        });

        booksList.forEach(System.out::println);
    }

    @Test
    void consumer_functional_interface() {
        Consumer<String> stringConsumer = (t) -> {
            System.out.println("t = " + t);
        };
        List<String> stringList = List.of("one", "two", "three");
        stringList.forEach(stringConsumer);
    }

    @Test
    void predicate_func_interface() {
        Predicate<Integer> evenChecker = t -> t % 2 == 0 ? true : false;
        List<Integer> numbersToCheck = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);

        System.out.println("evenChecker.test(7) = " + evenChecker.test(7));// invoke the predicate

        numbersToCheck.stream()
                .filter(evenChecker)
                .forEach(x -> System.out.println(x));
    }

    @Test
    void supplier_func_interface() {
        Supplier<String> supplier = () -> "hello";
        System.out.println("supplier.get() = " + supplier.get());
        List<String> stringList = Collections.emptyList();
        String s = stringList.stream().findAny().orElseGet(supplier); // empty list, so supplier will be called
        assertTrue(s.equalsIgnoreCase(supplier.get()));
    }

    @Test
    void simple_state_change_impl() {
        StateOwner stateOwnerObject = new StateOwner();

        stateOwnerObject.addListener((oldState, newState) -> {
            System.out.println("step 1: oldState is manipulated by newState");
            //throw new InterruptedException("some exception");
        });

        stateOwnerObject.addListener((oldState, newState) -> {
            System.out.println("step 2: oldState is manipulated by newState");
        });

        stateOwnerObject.notifyChange();
    }

    @Test
    void bi_function_test() {
        BiFunction<String, String, Integer> funcPointer = this::func1;
        Integer apply = funcPointer.apply("one", "seven");
        assertEquals(8, apply);
    }

    private Integer func1(String arg1, String arg2) {
        return arg1.length() + arg2.length();
    }
}
