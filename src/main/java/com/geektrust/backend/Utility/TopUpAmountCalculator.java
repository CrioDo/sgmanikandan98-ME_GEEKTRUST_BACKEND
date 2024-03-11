package com.geektrust.backend.Utility;

import com.geektrust.backend.entities.Topup;

public class TopUpAmountCalculator {

    public static long calculateAmount(int noOfDevice){
        if(noOfDevice>0 && noOfDevice <=4){
            return constant.UPTO_FOUR_DEVICE;
        }

        if(noOfDevice>4 && noOfDevice<=10){
            return constant.UPTO_TEN_DEVICE;
        }

        return 0;
    }


    public static long calculateTotalAmount(Topup topup){
        long ans=0;
        if(topup!=null){
           if(topup.getDevice()<=4){
            ans+=constant.UPTO_FOUR_DEVICE*topup.getMonths();
           }
           else{
            ans+=constant.UPTO_TEN_DEVICE*topup.getMonths();
           }
        }
        return ans;
    }
    
}
