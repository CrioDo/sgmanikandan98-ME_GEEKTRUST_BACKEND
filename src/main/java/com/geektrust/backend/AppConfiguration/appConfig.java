package com.geektrust.backend.AppConfiguration;

import com.geektrust.backend.Command.AddSubscriptionCommand;
import com.geektrust.backend.Command.AddTopUpCommand;
import com.geektrust.backend.Command.CommandInvoker;
import com.geektrust.backend.Command.PrintRenewDetailsCommand;
import com.geektrust.backend.Command.StartSubscriptionCommand;
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

public class appConfig {

    private final ISubscriptionRepository subscriptionRepository=new SubscriptionRepository();
    private final ICategoryRepository categoryRepository=new CategoryRepository();
    private final ITopupRepository topupRepository=new  TopupRepository();

    private final ISubscriptionService subscriptionService=new SubscriptionService(subscriptionRepository);
    private final ICategoryService categoryService=new CategoryService(categoryRepository,subscriptionRepository);
    private final ITopUpService topUpService=new TopUpService(categoryRepository, subscriptionRepository,topupRepository);
    private final IRenewDetailsService renewDetailsService=new RenewDetailsService(subscriptionRepository, categoryRepository,topupRepository);

    private final StartSubscriptionCommand startSubscriptionCommand=new StartSubscriptionCommand(subscriptionService);
    private final AddSubscriptionCommand addSubscriptionCommand=new AddSubscriptionCommand(categoryService);
    private final AddTopUpCommand addTopUpCommand=new AddTopUpCommand(topUpService);
    private final PrintRenewDetailsCommand printRenewDetailsCommand=new PrintRenewDetailsCommand(renewDetailsService);

    private final CommandInvoker command=new CommandInvoker();

    public CommandInvoker getCommandInvoker(){
       command.register("START_SUBSCRIPTION", startSubscriptionCommand);
       command.register("ADD_SUBSCRIPTION", addSubscriptionCommand);
       command.register("ADD_TOPUP", addTopUpCommand);
       command.register("PRINT_RENEWAL_DETAILS",printRenewDetailsCommand);
       return command;
    }

    
    
}
