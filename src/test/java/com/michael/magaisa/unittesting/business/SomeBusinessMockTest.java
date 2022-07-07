package com.michael.magaisa.unittesting.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class SomeBusinessMockTest {
    @InjectMocks
    SomeBusinessImpl businessImpl;
    @Mock
    SomeDataService someDataServiceMock;

    @Test
    void calculateSimpleListUsingMockedDataService() {
        Mockito.when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] {1, 2, 3});
        assertEquals(6, businessImpl.getCalculationFromDataService());
    }

    @Test
    void calculateEmptyListUsingMockedDataService() {
        Mockito.when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] {});
        assertEquals(0, businessImpl.getCalculationFromDataService());
    }

    @Test
    void calculateListOfNegativeNumbers() {
        Mockito.when(someDataServiceMock.retrieveAllData()).thenReturn(new int[] {-1, -2, 0});
        assertEquals(-3, businessImpl.getCalculationFromDataService());
    }
}
