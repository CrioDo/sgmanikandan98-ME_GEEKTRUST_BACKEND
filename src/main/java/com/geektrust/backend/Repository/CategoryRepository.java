package com.geektrust.backend.Repository;


import com.geektrust.backend.entities.Category;
import java.util.*;
import java.util.stream.Collectors;

public class CategoryRepository  implements ICategoryRepository{

    private final Map<String,Category>catsMap=new HashMap<>();
    

    @Override
    public Category save(String subscriptionCategory,String SubscriptionPlan) {
       
        Category obj=new Category(subscriptionCategory, SubscriptionPlan);
        catsMap.put(subscriptionCategory, obj);
        return obj;

    }

    @Override
    public boolean isSubscribed(String subscriptionCategory) {
        Optional<Category> obj=Optional.ofNullable(catsMap.get(subscriptionCategory));
        return obj.isPresent();
    }


    @Override
    public boolean isSubscriptionAvailable() {
        return  !catsMap.isEmpty();
    }


    @Override
    public List<Category> findAll() {
       return catsMap.values().stream().collect(Collectors.toList());
    }
      
    
}
