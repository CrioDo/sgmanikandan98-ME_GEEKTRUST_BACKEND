package com.geektrust.backend.Repository;

import java.time.LocalDate;
import java.util.*;
import com.geektrust.backend.entities.Subscription;


public class SubscriptionRepository implements ISubscriptionRepository{
    private final Map<String,Subscription>subsMap=new HashMap<>();

    @Override
    public void startSubscription(LocalDate date) {
        if(date!=null){
         Subscription obj=new Subscription(date);
          subsMap.put("startDate",obj);   
        }
        System.out.println(subsMap.size());
    }
    
    @Override
    public boolean isSubscriptionAvailable() {
        if(subsMap.size()==0){
        return false;
        }
        return true;
    }

    @Override
    public LocalDate startDate() {
       if(!subsMap.isEmpty()){
        return subsMap.get("startDate").getStartDate();

       }
      return null;
        
    }

   
}
