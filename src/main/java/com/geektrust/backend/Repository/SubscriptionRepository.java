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
          subsMap.put(date.toString(),obj);   
        }
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
        return subsMap.values().stream().findAny().get().getStartDate();
       }
      return null;
        
    }

   
}
