package com.geektrust.backend.Utility;

public class categoryPlanAmountCalculator {
    

    public static long planAmount(String category,String plan){
        if(category.equalsIgnoreCase("Music")){
            switch(plan){
                case "FREE":
                    return 0;
                case "PERSONAL":
                    return 100;
                case "PREMIUM":
                    return 250;
            }
        }

        else if(category.equalsIgnoreCase("video")){
            switch(plan){
                case "FREE":
                    return 0;
                case "PERSONAL":
                    return 200;
                case "PREMIUM":
                    return 500;
            }
        }

        else if(category.equalsIgnoreCase("podcast")){
            switch(plan){
                case "FREE":
                    return 0;
                case "PERSONAL":
                    return 100;
                case "PREMIUM":
                    return 300;
            }

        }

        return 0;
    }
}
