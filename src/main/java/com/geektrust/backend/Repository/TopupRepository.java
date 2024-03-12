package com.geektrust.backend.Repository;

import java.util.*;
import java.util.stream.Collectors;
import com.geektrust.backend.entities.Topup;

public class TopupRepository implements ITopupRepository {

    private final Map<String,Topup> topupMap=new HashMap<>();

    @Override
    public boolean isTopUpAvailable() {
        return !topupMap.isEmpty();
    }

    @Override
    public void addTopUp(int noOfDevice, int months) {
        Topup topup=new Topup(noOfDevice, months);
        topupMap.put(String.valueOf(noOfDevice),topup);
    }

    @Override
    public List<Topup> findAll() {
        return topupMap.values().stream().collect(Collectors.toList());
    }
    
}
