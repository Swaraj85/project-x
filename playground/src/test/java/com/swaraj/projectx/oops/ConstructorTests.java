package com.swaraj.projectx.oops;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
