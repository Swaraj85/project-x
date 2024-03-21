package com.swaraj.projectx.collections;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayListTests {

    @Test
    void initialize_array_list() {
        List<String> myArrayList = new ArrayList<>();
        myArrayList.add("name1");
        myArrayList.add("name2");
        myArrayList.add("name3");
        System.out.println(myArrayList);
        myArrayList.add(1,"new-name");
        System.out.println(myArrayList);
        myArrayList.addAll(Arrays.asList("new-name2","new-name3"));
        System.out.println(myArrayList);

        myArrayList.remove("new-name3");
        System.out.println(myArrayList);

        System.out.println(myArrayList.get(1));

        myArrayList.remove(1);
        System.out.println(myArrayList);

        myArrayList.set(1,"new-inserted-name");
        System.out.println(myArrayList);
    }

    @Test
    void iterate_over(){
        List<String> myArrayList = new ArrayList<>();
        myArrayList.add("name1");
        myArrayList.add("name2");
        myArrayList.add("name3");
        System.out.println("using for loop");
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i));
        }
        System.out.println("using foreach second version");
        for (String element : myArrayList) {
            System.out.println(element);
        }

        System.out.println("using iterator");
        Iterator<String> stringIterator = myArrayList.iterator();
        while (stringIterator.hasNext()) {
            String value = stringIterator.next();
            System.out.println(value);
        }
    }
}
