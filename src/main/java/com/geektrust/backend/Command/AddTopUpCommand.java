package com.geektrust.backend.Command;

import java.util.List;
import com.geektrust.backend.Exception.DuplicateTopUpException;
import com.geektrust.backend.Exception.NosuchCommandException;
import com.geektrust.backend.Exception.SubscriptionNotFoundException;
import com.geektrust.backend.Service.ITopUpService;

public class AddTopUpCommand implements ICommand{

    private final ITopUpService service;

    public AddTopUpCommand(ITopUpService service) {
        this.service = service;
    }

    //input [ADD_TOPUP FOUR_DEVICE 3]

    @Override
    public void execute(List<String> token) {
        try{
        if(token.size()==3){
         service.addTopUp(token.get(1),Integer.valueOf(token.get(2)));
        }
        else{
            throw new NosuchCommandException("INVALID_COMMAND");
        }
    }
    catch(DuplicateTopUpException e){
        System.out.println(e.getMessage());
    }
    catch(SubscriptionNotFoundException e){
        System.out.println(e.getMessage());
    }
   
    }
    
}
