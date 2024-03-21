package com.swaraj.projectx.oops;

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
