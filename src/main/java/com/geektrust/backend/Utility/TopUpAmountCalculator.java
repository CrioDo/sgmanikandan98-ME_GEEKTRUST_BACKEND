package com.geektrust.backend.Utility;

import com.geektrust.backend.entities.Topup;

public class TopUpAmountCalculator {

    public static long calculateAmount(int noOfDevice){
        if(noOfDevice>constant.ZERO_DEVICE && noOfDevice <=constant.FOUR_DEVICE){
            return constant.UPTO_FOUR_DEVICE;
        }

        if(noOfDevice>constant.FOUR_DEVICE && noOfDevice<=constant.TEN_DEVICE){
            return constant.UPTO_TEN_DEVICE;
        }

        return constant.CONSTANT_ZERO;
    }


    public static long calculateTotalAmount(Topup topup){
        long ans=constant.CONSTANT_ZERO;
        if(topup!=null){
           if(topup.getDevice()<=constant.FOUR_DEVICE){
            ans+=constant.UPTO_FOUR_DEVICE*topup.getMonths();
           }
           else{
            ans+=constant.UPTO_TEN_DEVICE*topup.getMonths();
           }
        }
        return ans;
    }
    
}
