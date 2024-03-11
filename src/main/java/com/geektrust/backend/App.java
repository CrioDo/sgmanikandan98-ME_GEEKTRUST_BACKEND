package com.geektrust.backend;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import com.geektrust.backend.AppConfiguration.appConfig;
import com.geektrust.backend.Command.CommandInvoker;
import com.geektrust.backend.Exception.NosuchCommandException;

public class App {

	public static void main(String[] args) {
			
		List<String> commandLineArgs=new LinkedList<>(Arrays.asList(args));
	//	System.out.println(commandLineArgs);
           run(commandLineArgs);

	}

	public static void run(List<String> commandLineArgs){
		appConfig applicatiConfig=new appConfig();
		CommandInvoker commadnInvoker=applicatiConfig.getCommandInvoker();
		BufferedReader reader;
		String inputFile=commandLineArgs.get(0);

		try{
			reader=new BufferedReader(new FileReader(inputFile));
			String line=reader.readLine();

			while(line!=null){

				List<String>tokens=Arrays.asList(line.split(" "));
				commadnInvoker.executeCommand(tokens.get(0), tokens);
				line=reader.readLine();
			}
			reader.close();
		}
		catch(IOException | NosuchCommandException e){
            e.getMessage();
		}

	}

}
