package com.geektrust.backend.Command;

import java.util.List;
import com.geektrust.backend.Exception.SubscriptionNotFoundException;
import com.geektrust.backend.Service.IRenewDetailsService;

import com.geektrust.backend.Utility.constant;

public class PrintRenewDetailsCommand implements ICommand{
    
  private final IRenewDetailsService service;
    public PrintRenewDetailsCommand(IRenewDetailsService service) {
    this.service = service;
}

 
    @Override
    public void execute(List<String> token) {
        try{
            if(token.size()==constant.TOKEN_SIZE_ONE){
                long ans=service.renewalAmount();
                System.out.println("RENEWAL_AMOUNT "+ans);
            }
        }
        catch(SubscriptionNotFoundException e){
            System.out.println(e.getMessage());
        } 
    }
    
}
