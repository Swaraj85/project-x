package com.swaraj.projectx.oops;

import com.swaraj.projectx.cars.CarException;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

interface MyInterface {
    public static final String name = "someName"; // public, static and final not required, implicit
    public void someMethod() throws CarException;
}

interface MyOtherInterface {
    void method2();
}

class MyInterfaceImpl implements MyInterface, MyOtherInterface {

    @Override
    public void someMethod() throws CarException {
        if (someNumberExists()) {
            throw new CarException("something bad happened");
        }
    }

    private boolean someNumberExists() {
        return false;
    }

    @Override
    public void method2() {

    }
}

public class InterfaceTests {

    @Test
    void interface_test() {
        String name = MyInterface.name;
        System.out.println("name = " + name);
    }
}
