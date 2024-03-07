package com.geektrust.backend.Command;

import java.util.*;
import com.geektrust.backend.Exception.InvalidDateException;
import com.geektrust.backend.Exception.NosuchCommandException;
import com.geektrust.backend.Service.ISubscriptionService;


public class StartSubscriptionCommand implements ICommand{

    private final ISubscriptionService service;

    public StartSubscriptionCommand(ISubscriptionService service) {
        this.service = service;
    }

   //input[START_SUBSCRIPTION 20-02-2022]

    @Override
    public void execute(List<String> token) {
        try{
                service.startSubscribe(token.get(1));
        }
        catch(NosuchCommandException e){
            System.out.println(e.getMessage());
        }
        catch(InvalidDateException f){
            System.out.println(f.getMessage());
        }
       
        
    }
    
}
