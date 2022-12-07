package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class Assignment3Test {

    @Mock
    private Assignment3 fibnos;

    //
    @Test
    void testFibo() {
        int[] intList = new int[] { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 };
        System.out.print("HI" + fibnos.fibo(10));
        assertEquals(Arrays.asList(intList), fibnos.fibo(10));
    }

}
