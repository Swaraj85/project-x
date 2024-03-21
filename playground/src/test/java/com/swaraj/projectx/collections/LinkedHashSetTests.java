package com.swaraj.projectx.collections;

import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Student implements Comparable<Student> {
    String name;
    int rollNumber;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return rollNumber == student.rollNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNumber);
    }

    @Override
    public int compareTo(Student that) {
        //if return is positive , it means this > that, s1.compareTo(s2) i.e. s1 > s2, here s1 is "this" and s2 is "that"
        // so as per current logic, student with higher roll number is greater than student with lower roll number
        return this.rollNumber - that.rollNumber;
    }
}

public class LinkedHashSetTests {

    @Test
    void init_test() {
        // insertion order of elements are maintained
        Set<Integer> set = new LinkedHashSet<>();
        set.add(34);
        set.add(99);
        set.add(23);
        set.add(34);
        set.add(6);
        System.out.println(set);
    }

    @Test
    void object_as_key_test() {
        Set<Student> studentSet = new HashSet<>();
        Student s1 = new Student("name1", 23);
        Student s2 = new Student("name2", 23);

        studentSet.add(s1);
        studentSet.add(s2);

        System.out.println(studentSet);

        assertTrue(s1.equals(s2));
        assertTrue(studentSet.contains(new Student("name1", 23)));
    }
}
