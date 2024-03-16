package com.geektrust.backend.Utility;

import java.time.LocalDate;

public class RenewalDate {

   
    public static LocalDate renewalDate(LocalDate date, String subscriptionPlan){

        LocalDate renewalDate=null;

        if(subscriptionPlan.equalsIgnoreCase("PREMIUM")){
              renewalDate=date.plusMonths(constant.PREMIUM_MONTH).minusDays(constant.NO_OF_BEFORE_NOTIFIED);
            
        }
        else{
            renewalDate=date.plusMonths(constant.PERSONAL_MONTH).minusDays(constant.NO_OF_BEFORE_NOTIFIED);
        }
        
       return renewalDate;
    }
    
}
