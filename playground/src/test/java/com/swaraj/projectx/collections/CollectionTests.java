package com.swaraj.projectx.collections;

import com.swaraj.projectx.cars.ConcreteCar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionTests {
    private final static Collection<ConcreteCar> concreteCars;
    static {
        concreteCars = new ArrayList<>();
        concreteCars.add(new ConcreteCar("tata", 12));
        concreteCars.add(new ConcreteCar("volks", 2));
        concreteCars.add(new ConcreteCar("nissan", 23));
    }

    @BeforeAll
    static void init(){}

    @Test
    void testCollectionCount() {
        assertEquals(3, concreteCars.size());
    }
}
