package com.geektrust.backend.Service;

import java.time.LocalDate;
import com.geektrust.backend.Exception.DuplicateCategoryException;
import com.geektrust.backend.Exception.InvalidInputException;
import com.geektrust.backend.Exception.SubscriptionNotFoundException;
import com.geektrust.backend.Repository.ICategoryRepository;
import com.geektrust.backend.Repository.ISubscriptionRepository;
import com.geektrust.backend.entities.Category;

public class CategoryService implements ICategoryService {

    private final ICategoryRepository catrepo;
    private final ISubscriptionRepository subrepo;
    
    public CategoryService(ICategoryRepository catrepo, ISubscriptionRepository subrepo) {
        this.catrepo = catrepo;
        this.subrepo = subrepo;
    }

    @Override
    public Category subscribe(String subscriptionCategory, String SubcriptionPlan) {

        if(subscriptionCategory.isEmpty() || SubcriptionPlan==null || SubcriptionPlan.isEmpty()
        || SubcriptionPlan==null){
            throw new InvalidInputException("INVALID_INPUT");  
        }

        if(!subrepo.isSubscriptionAvailable()){
            throw new SubscriptionNotFoundException("ADD_SUBSCRIPTION_FAILED INVALID_DATE");
        }

        if(catrepo.isSubscribed(subscriptionCategory)){
            throw new DuplicateCategoryException("ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY");
        }
      
        Category obj=catrepo.save(subscriptionCategory, SubcriptionPlan);
        LocalDate date=subrepo.startDate();
        LocalDate renewalDate=catrepo.renewalDate(date, SubcriptionPlan);
        return new Category(obj.getPlanCategory(), obj.getPlanName(),renewalDate);
    }

   

   
    
}
