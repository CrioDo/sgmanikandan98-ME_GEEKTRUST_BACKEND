package com.geektrust.backend.Command;

import java.util.List;
import com.geektrust.backend.Exception.SubscriptionNotFoundException;
import com.geektrust.backend.Service.IRenewDetailsService;
import com.geektrust.backend.dto.RenewalAmount;
import com.geektrust.backend.dto.RenewalReminder;


public class PrintRenewDetailsCommand implements ICommand{
    
  private final IRenewDetailsService service;
    public PrintRenewDetailsCommand(IRenewDetailsService service) {
    this.service = service;
}

    @Override
    public void execute(List<String> token) {
        try{    
            RenewalAmount amount=service.renewalAmount();
            List<RenewalReminder> ls=service.renewalReminder();
            ls.forEach(e->System.out.println(e.toString()));
            System.out.println(amount.toString());
        }
        catch(SubscriptionNotFoundException m){
            System.out.println(m.getMessage());
        } 
        catch(Exception w){
            System.out.println(w.toString());
        }
    }
    
}
