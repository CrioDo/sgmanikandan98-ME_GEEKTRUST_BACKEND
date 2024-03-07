package com.geektrust.backend.Utility;

public class TopUpAmountCalculator {

    public static long calculateAmount(int noOfDevice){
        if(noOfDevice>0 && noOfDevice <=4){
            return 50;
        }

        if(noOfDevice>4 && noOfDevice<=10){
            return 100;
        }

        return 0;
    }
    
}
