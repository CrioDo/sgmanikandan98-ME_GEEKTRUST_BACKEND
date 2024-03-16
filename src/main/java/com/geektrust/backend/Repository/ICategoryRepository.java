package com.geektrust.backend.Repository;

import java.time.LocalDate;
import com.geektrust.backend.entities.Category;
import java.util.*;

public interface ICategoryRepository {

    public Category save(String subcriptionCategory,String SubscriptionPlan);
    public boolean findByCategory(String Category);
    public boolean isSubscribed(String subscriptionCategory);
    public boolean isSubscriptionAvailable();
    public List<Category> findAll();
    
    
    
}
