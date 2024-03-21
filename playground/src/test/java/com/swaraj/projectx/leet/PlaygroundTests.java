package com.swaraj.projectx.leet;

import com.swaraj.projectx.cars.ConcreteCar;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Function.*;
import static java.util.stream.Collectors.*;

public class PlaygroundTests {

    @Test
    void find_min_max() {
        int[] nums = {9, 5, 2, 1, 99, 345};

        // find min value
        int lowestValue = nums[0];
        for (int x = 0; x < nums.length; x++) {
            if (nums[x] <= lowestValue)
                lowestValue = nums[x];
        }

        //find max value
        int maxValue = nums[0];
        for (int outer = 0; outer < nums.length; outer++) {
            if (nums[outer] >= maxValue)
                maxValue = nums[outer];
        }

        System.out.println(lowestValue);
        System.out.println(maxValue);
    }

    @Test
    void sum_of_all_nums() {
        int[] nums = {1, 2, 3, 4, 5};
        int result = 0;
        for (int outer = 0; outer < nums.length; outer++) {
            result = result + nums[outer];
        }

        System.out.println(result);
    }

    @Test
    void basic_encoding() {
        int smallARepresent = 'a';
        int smallZRepresent = 'z';
        System.out.println("smallARepresent = " + smallARepresent);
        System.out.println("smallZRepresent = " + smallZRepresent);

        int in_decimal_5 = '5';
        System.out.println("in_decimal_5 = " + in_decimal_5);
        System.out.println("Integer.toHexString(205) = " + Integer.toHexString(205));
        System.out.println("Integer.parseUnsignedInt(\"cd\",16) = " + Integer.parseUnsignedInt("cd", 16));
    }

    @Test
    void interview_prep() {
        /*Runnable;
        Callable;
        Comparator*/
        new Random().nextInt(100);
        Supplier<String> stringSupplier = () -> "hola";
        String magicNumberGenerated = methodUsingSupplier(stringSupplier);
        System.out.println("magicNumberGenerated = " + magicNumberGenerated);

        List<ConcreteCar> myCarCollection = new ArrayList<>();
        List<ConcreteCar> sortedCars = myCarCollection.stream()
                .filter(car -> car.getAge() > 4)
                .sorted(Comparator.comparingInt(ConcreteCar::getAge))
                .collect(toList());

        //frequency of character in string
        Map<String, Long> numberofcharacter = Stream.of("numberofcharacter".split(""))
                .collect(groupingBy(identity(), counting()));
        System.out.println(numberofcharacter);

        Map<Integer, List<ConcreteCar>> collect = myCarCollection.stream()
                .collect(groupingBy(ConcreteCar::getAge));
        System.out.printf("executing in thread: %s", Thread.currentThread().getName());
    }

    @Test
    void interview_prep2() {
//        System.out.println(2024 / 100);
//        System.out.println(2024 % 100);
        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("one", 2);
        System.out.println(map);
    }

    String methodUsingSupplier(Supplier<String> stringGenerator) {
        String s = stringGenerator.get();
        return s + new Random().nextInt(10);
    }
}
