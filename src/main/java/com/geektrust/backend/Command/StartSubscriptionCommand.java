package com.geektrust.backend.Command;


import java.util.*;
import com.geektrust.backend.Exception.InvalidDateException;
import com.geektrust.backend.Exception.NosuchCommandException;
import com.geektrust.backend.Service.ISubscriptionService;
import com.geektrust.backend.Utility.constant;


public class StartSubscriptionCommand implements ICommand{

    private final ISubscriptionService service;

    public StartSubscriptionCommand(ISubscriptionService service) {
        this.service = service;
    }

  

    @Override
    public void execute(List<String> token) {
        try{
                service.startSubscribe(token.get(constant.TOKEN_ONE));
        }
        catch(NosuchCommandException e){
            System.out.println(e.getMessage());
        }
        catch(InvalidDateException f){
            System.out.println(f.getMessage());
        }
        catch(Exception g){
            System.out.println(g.toString());
        }
       
        
    }
    
}
