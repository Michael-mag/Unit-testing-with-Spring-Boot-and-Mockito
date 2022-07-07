package com.michael.magaisa.unittesting.business;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListMockTest {

    @Test
    void testList(){
        List listMock = Mockito.mock(List.class);
        Mockito.when(listMock.size()).thenReturn(-1);
        assertEquals(-1, listMock.size());

    }

    @Test
    void testListCombinationCalls(){
        List listMok = Mockito.mock(List.class);
        Mockito.when(listMok.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, listMok.size());
        assertEquals(10, listMok.size());
    }
}
