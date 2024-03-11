package com.geektrust.backend.Repository;

import java.util.*;
import java.util.stream.Collectors;
import com.geektrust.backend.Utility.constant;
import com.geektrust.backend.entities.Topup;

public class TopupRepository implements ITopupRepository {

    private final Map<String,Topup> topupMap=new HashMap<>();

    @Override
    public boolean isTopUpAvailable() {
       if(topupMap.size()>constant.CONSTANT_ZERO){
        return true;
       }
        return false;
    }

    @Override
    public void addTopUp(int noOfDevice, int months) {
        Topup topup=null;
        if((noOfDevice>0 && noOfDevice<=10) || months>0){
             topup=new Topup(noOfDevice, months);
             topupMap.put(String.valueOf(noOfDevice),topup);
        }
    }

    @Override
    public List<Topup> findAll() {
        return topupMap.values().stream().collect(Collectors.toList());
    }
    
}
