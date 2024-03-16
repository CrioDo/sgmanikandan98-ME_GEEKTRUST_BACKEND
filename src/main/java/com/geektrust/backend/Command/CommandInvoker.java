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

    
 
}
