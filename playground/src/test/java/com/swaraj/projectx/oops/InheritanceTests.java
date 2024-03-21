package com.swaraj.projectx.oops;

import com.swaraj.projectx.cars.ConcreteCar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

public class InheritanceTests {

    interface IAdorable {
        boolean isAdorable(); //abstract method by default
    }

    @Data
    class Person implements IAdorable {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public <T> T calculateMagicAge(Function<String, T> ageCalculator) {
            T apply = ageCalculator.apply(name);
            return apply;
        }

        @Override
        public boolean isAdorable() {
            return false;
        }
    }

    /*
    * student "is-a" person
    * is-a = inheritance
    * */
    class Student extends Person {
        public Student(String name, int age) {
            super(name, age);
        }
    }

    @Test
    void student_inheritance() {
        Person person = new Student("swaraj", 39);
        /*
         * "swaraj" will get converted to 6, i.e. count of characters in string
         * */
        Integer magicAge = person.calculateMagicAge(s -> s.length());
        assertEquals(39, person.getAge());
        assertEquals(6, magicAge);
    }

    @Test
    void interface_is_relation() {
        Person person = new Student("swaraj", 39);
        IAdorable adorable = person;
        assertFalse(adorable.isAdorable());
    }

    @Test
    void test_instance_of() {
        Student student = new Student("swaraj", 39);
        assertTrue(student instanceof Person);
        assertTrue(student instanceof IAdorable);
        assertTrue(student instanceof Object);
    }
}
