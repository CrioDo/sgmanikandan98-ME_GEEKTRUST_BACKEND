package com.geektrust.backend.Utility;

import com.geektrust.backend.entities.Category;

public class categoryPlanAmountCalculator {
    

    public static long planAmount(String category,String plan){
        if(category.equalsIgnoreCase("Music")){
            switch(plan){
                case "FREE":
                    return constant.MUSIC_FREE;
                case "PERSONAL":
                    return constant.MUSIC_PERSONAL;
                case "PREMIUM":
                    return constant.MUSIC_PREMIUM;
            }
        }

        else if(category.equalsIgnoreCase("video")){
            switch(plan){
                case "FREE":
                    return constant.VIDEO_FREE;
                case "PERSONAL":
                    return constant.VIDEO_PERSONAL;
                case "PREMIUM":
                    return constant.VIDEO_PREMIOUM;
            }
        }

        else if(category.equalsIgnoreCase("podcast")){
            switch(plan){
                case "FREE":
                    return constant.PODCAST_FREE;
                case "PERSONAL":
                    return constant.PODCAST_PERSONAL;
                case "PREMIUM":
                    return constant.PODCAST_PREMIUM;
            }

        }

        return 0;
    }


    public static long calculateTotalAmount(Category cat){
        long ans=constant.CONSTANT_ZERO;
        if(cat!=null){
            ans+=planAmount(cat.getPlanCategory(), cat.getPlanName());
        }
        return ans; 
    }
}
