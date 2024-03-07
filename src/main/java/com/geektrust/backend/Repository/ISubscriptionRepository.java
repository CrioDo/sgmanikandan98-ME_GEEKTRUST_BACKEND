package com.geektrust.backend.Repository;

import java.time.LocalDate;

public interface ISubscriptionRepository {
    
    public void startSubscription(LocalDate date);
    public boolean isSubscriptionAvailable();
    public LocalDate startDate();
    
}
