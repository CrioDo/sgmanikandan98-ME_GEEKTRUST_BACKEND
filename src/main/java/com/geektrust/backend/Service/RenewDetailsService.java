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
    public long printdetails() {

        if(!subrepo.isSubscriptionAvailable()){
            throw new SubscriptionNotFoundException("SUBSCRIPTIONS_NOT_FOUND");
        }
        if(!catrepo.isSubscriptionAvailable()){
            throw new SubscriptionNotFoundException("SUBSCRIPTIONS_NOT_FOUND");
        }
        List<Topup> topup=topuprepo.findAll();
        List<Category> category=catrepo.findAll();

        long ans=planAmount(category)+topupAmount(topup);
        return ans;
    }

    public long planAmount(List<Category> category){
        long ans=0;
        if(category!=null){
            for(Category obj: category){
            ans+=categoryPlanAmountCalculator.planAmount(obj.getPlanCategory(),obj.getPlanName());
            }
        }
        return ans; 
    }

    public long topupAmount(List<Topup> topup){
        long ans=0;

        if(topup!=null){
            for(Topup obj:topup){
                ans+=(obj.getMonths())*(TopUpAmountCalculator.calculateAmount(obj.getDevice()));
            }  
        }
        return ans;
    }
    
}
