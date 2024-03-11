package com.geektrust.backend.Repository;

import com.geektrust.backend.Utility.DateValidator;
import com.geektrust.backend.entities.Category;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class CategoryRepository  implements ICategoryRepository{

    private final Map<String,Category>catsMap=new HashMap<>();
    

    @Override
    public Category save(String subscriptionCategory,String SubscriptionPlan) {
       
       if(subscriptionCategory!=null && SubscriptionPlan!=null){
        Category obj=new Category(subscriptionCategory, SubscriptionPlan);
        catsMap.put(subscriptionCategory, obj);
        return obj;
       }
       
        return null;
    }

    @Override
    public boolean findByCategory(String Category) {
       
        return true;
    }


    @Override
    public String renewalDate(LocalDate date, String subscriptionPlan){

        LocalDate renewalDate=null;
        if(subscriptionPlan.equalsIgnoreCase("PREMIUM")){

            if(date.getMonth()==Month.FEBRUARY){
            renewalDate=date.plusDays(79);
                }
            else{
            renewalDate=date.plusDays(80);
                }
        }
        else{

            if(date.getMonth()==Month.FEBRUARY){
                renewalDate=date.plusDays(18);
               }
            else{
            renewalDate=date.plusDays(20);
                }
        }
        
       return DateValidator.formatDate(renewalDate.toString());
    }

    @Override
    public boolean isSubscribed(String subscriptionCategory) {
        Optional<Category> obj=Optional.ofNullable(catsMap.get(subscriptionCategory));
        return obj.isPresent();
    }

    @Override
    public boolean isSubscriptionAvailable() {
        if(catsMap.size()>0){
            return true;
        }
        return false;
    }

    @Override
    public List<Category> findAll() {
       return catsMap.values().stream().collect(Collectors.toList());
    }


    
    
}
