package com.geektrust.backend.Command;

import java.util.List;
import com.geektrust.backend.Exception.DuplicateTopUpException;
import com.geektrust.backend.Exception.SubscriptionNotFoundException;
import com.geektrust.backend.Service.ITopUpService;
import com.geektrust.backend.Utility.constant;

public class AddTopUpCommand implements ICommand{

    private final ITopUpService service;

    public AddTopUpCommand(ITopUpService service) {
        this.service = service;
    }


    @Override
    public void execute(List<String> token) {
        try{
         service.addTopUp(token.get(constant.TOKEN_ONE),Integer.valueOf(token.get(constant.TOKEN_TWO)));
    }
    catch(DuplicateTopUpException s){
        System.out.println(s.getMessage());
    }
    catch(SubscriptionNotFoundException d){
        System.out.println(d.getMessage());
    }
    catch(Exception x){
        System.out.println(x.toString());
    }
   
    }
    
}
