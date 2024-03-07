package com.geektrust.backend.Command;
import java.util.*;
import com.geektrust.backend.Exception.NosuchCommandException;

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

    // public static void main(String[] args) {

    //     CommandInvoker obj=new CommandInvoker();

       // ICategoryRepository catrepo=new CategoryRepository();
      //  ISubscriptionRepository subrepo=new SubscriptionRepository();
    //     ITopupRepository toprepo=new TopupRepository();

    //     //ITopUpService service=new TopUpService(catrepo, subrepo, toprepo);
    //     ISubscriptionService subservice=new SubscriptionService(subrepo);
    //     ICategoryService service=new CategoryService(catrepo, subrepo);

    //     //ICommand command=new AddTopUpCommand(service);
    //     ICommand command=new StartSubscriptionCommand(subservice);
    //     command=new AddSubscriptionCommand(service);



    //     obj.register("START_SUBSCRIPTION", command);
    //     List<String> token=Arrays.asList("START_SUBSCRIPTION","20-02-2022");

    //     obj.register("ADD_SUBSCRIPTION", command);
    //     List<String> token1=Arrays.asList("ADD_SUBSCRIPTION","MUSIC","PERSONAL");

    //     obj.executeCommand("START_SUBSCRIPTION",token );
    //     obj.executeCommand("ADD_SUBSCRIPTION",token1);
    // }
    
}
