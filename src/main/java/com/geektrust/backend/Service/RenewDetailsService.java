package com.geektrust.backend.Service;

import java.util.*;
import com.geektrust.backend.Exception.SubscriptionNotFoundException;
import com.geektrust.backend.Repository.ICategoryRepository;
import com.geektrust.backend.Repository.ISubscriptionRepository;
import com.geektrust.backend.Repository.ITopupRepository;
import com.geektrust.backend.Utility.TopUpAmountCalculator;
import com.geektrust.backend.Utility.categoryPlanAmountCalculator;
import com.geektrust.backend.entities.Category;
import com.geektrust.backend.entities.Topup;

public class RenewDetailsService implements IRenewDetailsService{

    private final ISubscriptionRepository subrepo;
    private final ICategoryRepository catrepo;
    private final ITopupRepository topuprepo;

    public RenewDetailsService(ISubscriptionRepository subrepo, ICategoryRepository catrepo,
            ITopupRepository topuprepo) {
        this.subrepo = subrepo;
        this.catrepo = catrepo;
        this.topuprepo = topuprepo;
    }


    @Override
    public long renewalAmount() {

        if(!subrepo.isSubscriptionAvailable()){
            throw new SubscriptionNotFoundException("SUBSCRIPTIONS_NOT_FOUND");
        }
        if(!catrepo.isSubscriptionAvailable()){
            throw new SubscriptionNotFoundException("SUBSCRIPTIONS_NOT_FOUND");
        }

        List<Topup> tp=topuprepo.findAll();
        List<Category> ct=catrepo.findAll();
        long amount=0;
        for(Category a:ct){
             amount+=categoryPlanAmountCalculator.calculateTotalAmount(a);
        }
        for(Topup a:tp){
            amount+=TopUpAmountCalculator.calculateTotalAmount(a);
        }
        return amount;       
    }

   
    
}
