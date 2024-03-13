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
 
}
