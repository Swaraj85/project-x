package com.swaraj.projectx.oops;

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
