package com.michael.magaisa.unittesting.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeBusinessTest {

    SomeBusinessImpl business = new SomeBusinessImpl();

    @Test
    public void calculateSumBasic(){
        int actualResult = business.calculateSum(new int[] {1, 2, 3});
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSumOfEmptyArray(){
        int actualResult = business.calculateSum(new int[]{});
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }
}
