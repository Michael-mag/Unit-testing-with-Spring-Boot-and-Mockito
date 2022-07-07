package com.michael.magaisa.unittesting.business;

import java.util.Arrays;

public class SomeBusinessImpl {

    private SomeDataService someDataService;

    public SomeDataService getSomeDataService() {
        return someDataService;
    }

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(int[] data){
        return Arrays.stream(data).reduce(Integer::sum).orElse(0);
    }

    public  int getCalculationFromDataService(){
        return Arrays.stream(someDataService.retrieveAllData()).reduce(Integer::sum).orElse(0);
    }

}
