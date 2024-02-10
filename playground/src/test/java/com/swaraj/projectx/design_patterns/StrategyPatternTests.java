package com.swaraj.projectx.design_patterns;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

interface IFlyBehaviour {
    void fly();
}

interface IQuackBehaviour {
    void quack();
}

class Duck{
    private IFlyBehaviour flyBehaviour;
    private IQuackBehaviour quackBehaviour;

    // inject flyBehaviour and quackBehaviour via dependency injection
    Duck(IFlyBehaviour flyBehaviour, IQuackBehaviour quackBehaviour) {
        this.flyBehaviour = flyBehaviour;
        this.quackBehaviour = quackBehaviour;
    }

    public void display() {
        System.out.println("displaying duck");
        flyBehaviour.fly();
        quackBehaviour.quack();
    }
}

public class StrategyPatternTests {

    @Test
    void test_strategy_pattern() {
        IFlyBehaviour flyBehaviourA = () -> {
            System.out.println("--> flying with behaviour A");
        };

        IQuackBehaviour quackBehaviourB = () -> {
            System.out.println("--> quacking with behaviour B");
        };
        new Duck(flyBehaviourA, quackBehaviourB).display();
    }
}
