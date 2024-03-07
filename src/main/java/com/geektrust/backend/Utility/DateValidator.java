package com.geektrust.backend.Utility;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateValidator {

    public static boolean isvalidDate(String date){
        try{
        DateTimeFormatter sdf=DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate.parse(date,sdf);
        }
        catch(DateTimeException e){
        return false;
        }
        return true;
    }
    
}
