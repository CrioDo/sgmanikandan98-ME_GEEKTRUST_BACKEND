package com.geektrust.backend.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import com.geektrust.backend.Exception.InvalidDateException;
import com.geektrust.backend.Repository.ISubscriptionRepository;
import com.geektrust.backend.Utility.DateValidator;

public class SubscriptionService implements ISubscriptionService{

    private final ISubscriptionRepository repo;
    public SubscriptionService(ISubscriptionRepository repo) {
        this.repo = repo;
    }


    @Override
    public void startSubscribe(String date) {
        boolean res=DateValidator.isvalidDate(date);
        if(res){
            DateTimeFormatter sdf=DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate temp=LocalDate.parse(date,sdf);
            repo.startSubscription(temp);
        }
        else{
            throw new InvalidDateException("INVALID_DATE");
        } 
    }

    
    
}
