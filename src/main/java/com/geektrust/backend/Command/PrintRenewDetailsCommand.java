package com.geektrust.backend.Command;

import java.util.List;
import com.geektrust.backend.Exception.SubscriptionNotFoundException;
import com.geektrust.backend.Service.ITopUpService;

public class PrintRenewDetailsCommand implements ICommand{
    
  private final ITopUpService service;
    public PrintRenewDetailsCommand(ITopUpService service) {
    this.service = service;
}

  //input[PRINT_RENEWAL_DETAILS]
    @Override
    public void execute(List<String> token) {
        try{

            if(token.size()==1){
                long ans=service.renewalAmount();
                System.out.println("RENEWAL AMOUNT "+ans);
            }

        }
        catch(SubscriptionNotFoundException e){
            System.out.println(e.getMessage());
        }

        catch(Exception e){
            System.out.println(e.getMessage());
        }
      
        
    }
    
}
