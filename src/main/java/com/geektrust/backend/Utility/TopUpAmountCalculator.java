package com.geektrust.backend.Utility;

import com.geektrust.backend.entities.Topup;

public class TopUpAmountCalculator {

    public static long calculateAmount(int noOfDevice){
        if(noOfDevice>constant.ZERO_DEVICE_COUNT && noOfDevice <=constant.FOUR_DEVICE_COUNT){
            return constant.UPTO_FOUR_DEVICE;
        }

        if(noOfDevice>constant.FOUR_DEVICE_COUNT && noOfDevice<=constant.TEN_DEVICE_COUNT){
            return constant.UPTO_TEN_DEVICE;
        }

        return constant.CONSTANT_ZERO;
    }


    public static long calculateTotalAmount(Topup topup){
        long ans=constant.CONSTANT_ZERO;
       
           if(topup.getDevice()<=constant.FOUR_DEVICE_COUNT){
            ans+=constant.UPTO_FOUR_DEVICE*topup.getMonths();
           }
           
           else{
            ans+=constant.UPTO_TEN_DEVICE*topup.getMonths();
           }
        
        return ans;
    }
    
}
