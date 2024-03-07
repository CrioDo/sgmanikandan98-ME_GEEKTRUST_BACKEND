package com.geektrust.backend.Service;

import com.geektrust.backend.Exception.DuplicateTopUpException;
import com.geektrust.backend.Exception.InvalidInputException;
import com.geektrust.backend.Exception.SubscriptionNotFoundException;
import com.geektrust.backend.Repository.ICategoryRepository;
import com.geektrust.backend.Repository.ISubscriptionRepository;
import com.geektrust.backend.Repository.ITopupRepository;
import com.geektrust.backend.Utility.DeviceCalculator;

public class TopUpService implements ITopUpService {

    private final ICategoryRepository catrepo;
    private final ISubscriptionRepository subrepo;
    private final ITopupRepository toprepo;

    public TopUpService(ICategoryRepository catrepo, ISubscriptionRepository subrepo,
            ITopupRepository toprepo) {
        this.catrepo = catrepo;
        this.subrepo = subrepo;
        this.toprepo = toprepo;
    }

    @Override
    public void addTopUp(String noOfDevice, int noOfMonths) {

        if(noOfDevice==null || noOfMonths<0 ){
            throw new InvalidInputException("INVALID_DATA");
        }

        if(!subrepo.isSubscriptionAvailable()){
           throw new SubscriptionNotFoundException("ADD_TOPUP_FAILED SUBSCRIPTION_NOT_FOUND");
        }

        if(!catrepo.isSubscriptionAvailable()){
            throw new SubscriptionNotFoundException("ADD_TOPUP_FAILED SUBSCRIPTION_NOT_FOUND"); 
        }

        if(toprepo.isTopUpAvailable()){
            throw new DuplicateTopUpException("ADD_TOPUP_FAILED DUPLICATE_TOPUP");
        }
        int deviceNumber=DeviceCalculator.findDeviceCount(noOfDevice);

        if(deviceNumber>0 && deviceNumber<=10){
            toprepo.addTopUp(deviceNumber, noOfMonths);
        }
        else{
            throw new InvalidInputException("INVALID_DATA");
        }
    
    }

    @Override
    public long renewalAmount() {
       
        return 0;
    }
    
}
