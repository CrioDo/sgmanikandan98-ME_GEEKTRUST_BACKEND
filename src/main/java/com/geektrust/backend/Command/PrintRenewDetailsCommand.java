package com.geektrust.backend.Command;

import java.util.List;
import com.geektrust.backend.Exception.SubscriptionNotFoundException;
import com.geektrust.backend.Service.IRenewDetailsService;


public class PrintRenewDetailsCommand implements ICommand{
    
  private final IRenewDetailsService service;
    public PrintRenewDetailsCommand(IRenewDetailsService service) {
    this.service = service;
}

    @Override
    public void execute(List<String> token) {
        try{    
            long ans=service.renewalAmount();
            System.out.println("RENEWAL_AMOUNT "+ans);
        }
        catch(SubscriptionNotFoundException m){
            System.out.println(m.getMessage());
        } 
        catch(Exception w){
            System.out.println(w.toString());
        }
    }
    
}
