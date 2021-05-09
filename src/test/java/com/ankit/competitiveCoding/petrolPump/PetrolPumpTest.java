package com.ankit.competitiveCoding.petrolPump;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

@RunWith(JUnit4.class)
public class PetrolPumpTest {

    @Test
    public void computeTest() {
        PetrolPump petrolPump = new PetrolPump(Arrays.asList(4, 1, 6, 2), Arrays.asList(9, 2, 5, 3));
        System.out.println(petrolPump.compute());
    }
}
