package com.geektrust.backend.Command;
import java.util.*;
import com.geektrust.backend.Exception.NosuchCommandException;

import com.geektrust.backend.Repository.CategoryRepository;
import com.geektrust.backend.Repository.ICategoryRepository;
import com.geektrust.backend.Repository.ISubscriptionRepository;
import com.geektrust.backend.Repository.ITopupRepository;
import com.geektrust.backend.Repository.SubscriptionRepository;
import com.geektrust.backend.Repository.TopupRepository;
import com.geektrust.backend.Service.CategoryService;
import com.geektrust.backend.Service.ICategoryService;
import com.geektrust.backend.Service.IRenewDetailsService;
import com.geektrust.backend.Service.ISubscriptionService;
import com.geektrust.backend.Service.ITopUpService;
import com.geektrust.backend.Service.RenewDetailsService;
import com.geektrust.backend.Service.SubscriptionService;
import com.geektrust.backend.Service.TopUpService;


public class CommandInvoker {

    private static final Map<String, ICommand> commandMap= new HashMap<>();

    public void register(String commandName, ICommand command){
        commandMap.put(commandName, command);
    }

    public ICommand get(String commandName){
        return commandMap.get(commandName);
    }

    public void executeCommand(String commandName, List<String> token){
        ICommand command=get(commandName);
        if(command==null){
            throw new NosuchCommandException("INVALID_COMMAND");
        }
        command.execute(token);

    }

    public static void main(String[] args) {

        CommandInvoker obj=new CommandInvoker();

        ICategoryRepository catrepo=new CategoryRepository();
        ISubscriptionRepository subrepo=new SubscriptionRepository();
        ITopupRepository toprepo=new TopupRepository();

        ITopUpService service=new TopUpService(catrepo, subrepo, toprepo);
        ISubscriptionService subservice=new SubscriptionService(subrepo);
        ICategoryService catservice=new CategoryService(catrepo, subrepo);
        IRenewDetailsService renewService=new RenewDetailsService(subrepo, catrepo, toprepo);

        ICommand command=new StartSubscriptionCommand(subservice);
        obj.register("START_SUBSCRIPTION", command);
        List<String> token=Arrays.asList("START_SUBSCRIPTION","20-02-2022");
        obj.executeCommand("START_SUBSCRIPTION",token );

        command=new AddSubscriptionCommand(catservice);
        obj.register("ADD_SUBSCRIPTION", command);
        List<String> token1=Arrays.asList("ADD_SUBSCRIPTION","MUSIC","PERSONAL");
        obj.executeCommand("ADD_SUBSCRIPTION",token1);

        command=new AddSubscriptionCommand(catservice);
        obj.register("ADD_SUBSCRIPTION", command);
         token1=Arrays.asList("ADD_SUBSCRIPTION","VIDEO","PREMIUM");
        obj.executeCommand("ADD_SUBSCRIPTION",token1);

        command=new AddSubscriptionCommand(catservice);
        obj.register("ADD_SUBSCRIPTION", command);
         token1=Arrays.asList("ADD_SUBSCRIPTION","PODCAST","FREE");
        obj.executeCommand("ADD_SUBSCRIPTION",token1);

        command=new AddTopUpCommand(service);
        obj.register("ADD_TOPUP", command);
        List<String> token2=Arrays.asList("ADD_TOPUP","FOUR_DEVICE","3");
        obj.executeCommand("ADD_TOPUP",token2);

        command=new PrintRenewDetailsCommand(renewService);
        obj.register("PRINT_RENEWAL_DETAILS", command);
        List<String> token3=Arrays.asList("PRINT_RENEWAL_DETAILS");
        obj.executeCommand("PRINT_RENEWAL_DETAILS",token3);
     }


    
 
}
