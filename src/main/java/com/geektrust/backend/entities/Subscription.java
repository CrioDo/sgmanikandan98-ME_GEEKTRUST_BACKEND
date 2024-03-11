package com.geektrust.backend.entities;

import java.time.LocalDate;
public class Subscription {

    private LocalDate startDate;

    public Subscription(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    
  
}
