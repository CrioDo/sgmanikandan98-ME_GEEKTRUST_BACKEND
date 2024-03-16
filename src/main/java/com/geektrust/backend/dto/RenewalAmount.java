package com.geektrust.backend.dto;

public class RenewalAmount {

    private long renewalAmount;

    public RenewalAmount(long renewalAmount) {
        this.renewalAmount = renewalAmount;
    }

    public long getRenewalAmount() {
        return renewalAmount;
    }

    public void setRenewalAmount(long renewalAmount) {
        this.renewalAmount = renewalAmount;
    }

    @Override
    public String toString() {
        return "RENEWAL_AMOUNT " + renewalAmount ;
    }

    

    
    
}
