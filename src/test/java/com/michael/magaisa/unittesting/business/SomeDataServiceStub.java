package com.michael.magaisa.unittesting.business;

public class SomeDataServiceStub implements SomeDataService{

    @Override
    public int[] retrieveAllData() {
        return new int[] {1, 2, 3};
    }
}
