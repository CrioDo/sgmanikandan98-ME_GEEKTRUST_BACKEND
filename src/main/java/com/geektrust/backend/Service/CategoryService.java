package com.geektrust.backend.Service;

import com.geektrust.backend.Exception.DuplicateCategoryException;
import com.geektrust.backend.Exception.SubscriptionNotFoundException;
import com.geektrust.backend.Repository.ICategoryRepository;
import com.geektrust.backend.Repository.ISubscriptionRepository;

public class CategoryService implements ICategoryService {

    private final ICategoryRepository catrepo;
    private final ISubscriptionRepository subrepo;
    
    public CategoryService(ICategoryRepository catrepo, ISubscriptionRepository subrepo) {
        this.catrepo = catrepo;
        this.subrepo = subrepo;
    }

    @Override
    public void subscribe(String subscriptionCategory, String SubcriptionPlan) {
        if(!subrepo.isSubscriptionAvailable()){
            throw new SubscriptionNotFoundException("ADD_SUBSCRIPTION_FAILED INVALID_DATE");
        }

        if(catrepo.isSubscribed(subscriptionCategory)){
            throw new DuplicateCategoryException("ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY");
        }
       catrepo.save(subscriptionCategory, SubcriptionPlan);
        
    }

   

   
    
}
