package com.swaraj.projectx.oops;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class MyGenericPipeline {
    void firstStep() {
        System.out.println("executing step 1");
    }

    void lastStep() {
        System.out.println("executing last step");
    }

    protected abstract void intermediateStep();

    public void process() {
        firstStep();
        intermediateStep();
        lastStep();
    }
}

class Pipeline1 extends MyGenericPipeline {
    @Override
    protected void intermediateStep() {
        System.out.println("executing custom intermediate step");
    }
}

public class AbstractClassTests {

    @Test
    void abstract_class_test() {
        MyGenericPipeline genericPipeline = new Pipeline1();
        genericPipeline.process(); // process the complete pipeline
        genericPipeline.intermediateStep(); // accessible within the same package, if kept outside this package, you cant access it
    }
}
