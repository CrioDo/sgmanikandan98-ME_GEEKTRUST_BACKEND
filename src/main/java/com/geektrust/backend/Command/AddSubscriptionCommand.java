package com.geektrust.backend.Command;

import java.util.List;
import com.geektrust.backend.Exception.DuplicateCategoryException;
import com.geektrust.backend.Exception.SubscriptionNotFoundException;
import com.geektrust.backend.Service.ICategoryService;
import com.geektrust.backend.Utility.constant;


public class AddSubscriptionCommand implements ICommand{

    private ICategoryService service;

    public AddSubscriptionCommand(ICategoryService service) {
        this.service = service;
    }

   
    @Override
    public void execute(List<String> token) {

        try{        
            service.subscribe(token.get(constant.TOKEN_ONE), token.get(constant.TOKEN_TWO));         
        }
        catch(SubscriptionNotFoundException u){
            System.out.println(u.getMessage());
        }
        catch(DuplicateCategoryException l){
            System.out.println(l.getMessage());
        }
        catch(Exception n){
            System.out.println(n.toString());
        }
        
    }
    

    
    
}
