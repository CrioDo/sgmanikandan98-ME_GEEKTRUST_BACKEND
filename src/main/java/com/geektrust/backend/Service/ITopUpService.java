package com.geektrust.backend.Service;

public interface ITopUpService {
    public void addTopUp(String noOfDevice, int noOfMonths );
    public long renewalAmount();
}
