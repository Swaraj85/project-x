package com.swaraj.projectx.oops;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class JavaBasicsClass {
    private String name;

    JavaBasicsClass(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JavaBasicsClass that = (JavaBasicsClass) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "JavaBasicsClass{" +
                "name='" + name + '\'' +
                '}';
    }
}

@FunctionalInterface
interface MyFunctionalInterface {
    static List<String> objects = new ArrayList<>(); // static class level variable
    void method1(); // only one abstract method

    default void method2() { // this is default method
        System.out.println("inside MyFunctionalInterface -> method2");
        objects.add("element added");
        //method3(); static method can be called from default method
    }

    static int method3() { // static methods are allowed
        System.out.println("static MyFunctionalInterface -> method3");
        return objects.size();
    }
}

class FunctionalInterfaceImpl implements MyFunctionalInterface {

    @Override
    public void method1() {

    }

    @Override
    public void method2() {
        MyFunctionalInterface.super.method2();
        MyFunctionalInterface.method3();
    }
}

class JavaBasicsChildClass extends JavaBasicsClass {
    public JavaBasicsChildClass(String name) {
        super(name);
    }
}

class MyNonAbstractClass {
    //abstract void method1(); method can be declared abstract if class is abstract
}

public class JavaBasicsTests {

    @Test
    void test_object_hash_code() {
        // equals and hash code functions are overriden
        JavaBasicsClass obj = new JavaBasicsClass("name");
        JavaBasicsClass obj2 = new JavaBasicsClass("name");
        System.out.println("obj.hashCode() = " + obj.hashCode());
        System.out.println("obj2.hashCode() = " + obj2.hashCode());
        assertEquals(obj, obj2);
    }

    @Test
    void test_to_string() {
        JavaBasicsClass obj = new JavaBasicsClass("name");
        System.out.println("obj.toString() = " + obj);
    }

    @Test
    void test_get_class() {
        JavaBasicsClass obj = new JavaBasicsClass("name");
        assertEquals(JavaBasicsClass.class, obj.getClass());

        JavaBasicsClass parentRef = new JavaBasicsChildClass("name");

        //JavaBasicsChildClass childRef = (JavaBasicsChildClass) new JavaBasicsClass("name");
        assertNotNull(parentRef);
    }

    @Test
    void test_wait_and_notify() throws InterruptedException {
        final Object lockObject = new Object();

        Thread thread1 = new Thread(() -> {
            synchronized (lockObject) {
                try {
                    System.out.println("going on wait in thread1");
                    lockObject.wait();
                    System.out.println("wait complete in thread1");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            synchronized (lockObject) {
                try {
                    System.out.println("waiting 5 sec before notifying from thread 2");
                    Thread.sleep(5000);
                    lockObject.notify();
                    System.out.println("notify signal sent from thread 2");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread2.start();

        System.out.println("waiting for thread 1 and thread 2 to complete in main thread");
        thread1.join();
        thread2.join();
        System.out.println("finished");
    }

    @Test
    void java8_interface_test() {
        MyFunctionalInterface myFunctionalInterface = new FunctionalInterfaceImpl();
        myFunctionalInterface.method2();
        myFunctionalInterface.method2();
        System.out.println("MyFunctionalInterface.method3() = " + MyFunctionalInterface.method3());
    }
}
