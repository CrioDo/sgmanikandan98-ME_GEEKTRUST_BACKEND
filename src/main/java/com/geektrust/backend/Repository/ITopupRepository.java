package com.geektrust.backend.Repository;
import java.util.*;
import com.geektrust.backend.entities.Topup;

public interface ITopupRepository {

    public void addTopUp(int noOfDevice, int months);

    public boolean isTopUpAvailable();

    public List<Topup> findAll();
    
    
}
