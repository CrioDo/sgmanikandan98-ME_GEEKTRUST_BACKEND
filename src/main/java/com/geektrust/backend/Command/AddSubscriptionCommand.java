package com.geektrust.backend.Command;

import java.time.format.DateTimeFormatter;
import java.util.List;
import com.geektrust.backend.Exception.DuplicateCategoryException;
import com.geektrust.backend.Exception.NosuchCommandException;
import com.geektrust.backend.Exception.SubscriptionNotFoundException;
import com.geektrust.backend.Service.ICategoryService;
import com.geektrust.backend.Utility.constant;
import com.geektrust.backend.entities.Category;

public class AddSubscriptionCommand implements ICommand{

    private ICategoryService service;

    public AddSubscriptionCommand(ICategoryService service) {
        this.service = service;
    }

    //input[ADD_SUBSCRIPTION MUSIC  PERSONAL]
    @Override
    public void execute(List<String> token) {

        try{
            Category obj=null;
            if(token.size()==constant.TOKEN_SIZE_THREE){
            obj= service.subscribe(token.get(constant.TOKEN_ONE), token.get(constant.TOKEN_TWO));
            }
            else{
                throw new NosuchCommandException("INVALID_COMMAND");
            }
            
            System.out.println("RENEWAL_REMINDER "+ obj.getPlanCategory()+" "+DateTimeFormatter.ofPattern(constant.DATE_PATTERN).format(obj.getRenewalDate()));
        }
        catch(SubscriptionNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch(DuplicateCategoryException f){
            System.out.println(f.getMessage());
        }
        
    }
    

    
    
}
