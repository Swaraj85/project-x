package com.swaraj.projectx.oops;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ParentClass {
    private String name;
    private int age;

    public ParentClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void method1() {
        System.out.println("inside ParentClass->method1");
    }

    //public abstract void parentMethod();

    @Override
    public String toString() {
        return "ParentClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class ChildClass extends ParentClass {
    private String email;
    private SomeClass someClassReference;

    public ChildClass(String name, int age, String email) {
        super(name, age); // call the base/super class, then initialize email
        this.email = email;
    }

    @Override
    public void method1() {
        super.method1();
        System.out.println("inside childclass->method1");
    }

    @Override
    public String toString() {
        return "ChildClass{" +
                "email='" + email + '\'' +
                "} " + super.toString();
    }

    public static ChildClass newHealthyChild() {
        return new ChildClass("healthy", 23, "healthy@gmail.com");
    }
}

class SomeClass {
    //holds some properties here
}

public class ConstructorTests {

    @Test
    void test_child_class_instantiation() {
        ParentClass parentClassRef = ChildClass.newHealthyChild();
        parentClassRef.method1(); // calls overriden method1 via parentclass reference
    }
}
