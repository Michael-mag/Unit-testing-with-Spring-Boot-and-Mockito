package com.michael.magaisa.unittesting.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeBusinessStubTest {

    @Test
    public void calculateSumUsingDataService(){
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStub());
        int actualResult = business.getCalculationFromDataService();
        int expectedResult = 6;

        assertEquals(expectedResult, actualResult);
    }
}
