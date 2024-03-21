package com.swaraj.projectx.collections;

import com.swaraj.projectx.cars.ConcreteCar;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class CollectionTests {
    private final static Collection<ConcreteCar> concreteCars;

    static {
        concreteCars = new ArrayList<>();
        concreteCars.add(new ConcreteCar("tata", 12));
        concreteCars.add(new ConcreteCar("volks", 2));
        concreteCars.add(new ConcreteCar("nissan", 23));
    }

    @BeforeAll
    static void init() {
    }

    @Test
    void testCollectionCount() {
        assertEquals(3, concreteCars.size());
    }

    @Test
    void emptyUnmodifiableList() {
        Collection<ConcreteCar> objects = Objects.isNull(concreteCars) ? Collections.emptyList() : concreteCars;
        assertEquals(objects.size(), concreteCars.size());
    }

    @Test
    void collections_functions() {
        List<Integer> integers = Arrays.asList(1, 22, 44, 23, 6, 7, 8, 456);
        System.out.println(integers);
        Collections.sort(integers);
        System.out.println(integers);
    }

    @Test
    void comparable_test() {
        Student s1 = new Student("name1", 1);
        Student s2 = new Student("name1", 2);
        Student s3 = new Student("name1", 34);
        Student s4 = new Student("name1", 9);

        System.out.println("s1 > s2 " + s1.compareTo(s2));
        System.out.println("s2 > s1 " + s2.compareTo(s1));
        System.out.println("s3 > s1 " + s3.compareTo(s1));
    }

    @Test
    void sorting_via_comparable_interface_test() {
        // student implements the comparable interface
        List<Student> students = Arrays.asList(new Student("name1", 1),
                new Student("name2", 2),
                new Student("name3", 34),
                new Student("name4", 9));
        System.out.println(students);
        Collections.sort(students);
        System.out.println(students);
    }

    @Test
    void sorting_via_comparator_test() {
        List<Student> students = Arrays.asList(new Student("aman", 1),
                new Student("sham", 2),
                new Student("niraj", 34),
                new Student("zhandu", 9),
                new Student("yogesh", 33));

        System.out.println(students);

        // lengthy form
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                /*
                * if "return value" +ive , this means o1 > o2
                * if "return value" -ive , this means o1 < o2
                * */
                return o1.name.compareTo(o2.name); // "string" also implements comparable interface
            }
        });

        // short form via lambda syntax
        students.sort((o1, o2) -> o1.name.compareTo(o2.name));
        //students.sort(Comparator.comparing(o -> o.name));

        System.out.println(students);
    }
}
