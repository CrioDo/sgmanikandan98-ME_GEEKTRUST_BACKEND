package com.geektrust.backend.Utility;


import java.time.*;
import java.time.format.DateTimeFormatter;


public class DateValidator {

    public static boolean isvalidDate(String date){
        try{
        DateTimeFormatter sdf=DateTimeFormatter.ofPattern(constant.DATE_PATTERN);
        LocalDate.parse(date,sdf);
        }
        catch(DateTimeException e){
        return false;
        }
        return true;
    }

    public static String formatDate(String inputdate){

        LocalDate Date=null;
        String formattedDate=null;
        DateTimeFormatter sdf=DateTimeFormatter.ofPattern(constant.DATE_PATTERN);
        DateTimeFormatter inputFormat=DateTimeFormatter.ofPattern(constant.INPUT_DATE_PATTERN);
        try{
            Date = LocalDate.parse(inputdate,inputFormat);
           formattedDate = Date.format(sdf);
        }
        catch(Exception e){
            System.out.println(e.getMessage()); 
        }

        return formattedDate;
        
    }
    
}
