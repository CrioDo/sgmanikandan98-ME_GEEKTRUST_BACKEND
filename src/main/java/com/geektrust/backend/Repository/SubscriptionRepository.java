package com.geektrust.backend.Repository;

import java.time.LocalDate;
import java.util.*;
import com.geektrust.backend.entities.Subscription;


public class SubscriptionRepository implements ISubscriptionRepository{
    private final Map<String,Subscription>subsMap=new HashMap<>();

    @Override
    public void startSubscription(LocalDate date) {
         Subscription obj=new Subscription(date);
          subsMap.put(date.toString(),obj);   
    }
    
    @Override
    public boolean isSubscriptionAvailable() {
        return !subsMap.isEmpty();
    }

    @Override
    public LocalDate startDate() { 
        return subsMap.values().stream().findAny().get().getStartDate(); 
    }

   
}
