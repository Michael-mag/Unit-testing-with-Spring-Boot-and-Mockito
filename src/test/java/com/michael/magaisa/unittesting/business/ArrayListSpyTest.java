package com.michael.magaisa.unittesting.business;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayListSpyTest {
    @Test
    void arrayListSpyTest(){
        ArrayList arrayListSpy = Mockito.spy(ArrayList.class);
        assertEquals(arrayListSpy.size(), 0);
        arrayListSpy.add(1);
        assertEquals(arrayListSpy.size(), 1);
        assertEquals(1, arrayListSpy.get(0));
        Mockito.when(arrayListSpy.size()).thenReturn(-1);
        assertEquals(arrayListSpy.size(), -1);
        arrayListSpy.add(1);
        assertEquals(arrayListSpy.size(), -1);
    }
}
