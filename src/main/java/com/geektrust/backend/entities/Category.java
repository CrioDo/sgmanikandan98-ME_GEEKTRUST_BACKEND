package com.geektrust.backend.entities;

import java.time.LocalDate;

public class Category {

    private String planCategory;
    private String planName;
    private LocalDate renewalDate;
    
   

    public Category(String planCategory, String planName, LocalDate renewalDate) {
        this.planCategory = planCategory;
        this.planName = planName;
        this.renewalDate = renewalDate;
    }

    public Category(String planCategory, String planName) {
        this.planCategory = planCategory;
        this.planName = planName;
    }



    public String getPlanCategory() {
        return planCategory;
    }

    public void setPlanCategory(String planCategory) {
        this.planCategory = planCategory;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public LocalDate getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(LocalDate renewalDate) {
        this.renewalDate = renewalDate;
    }

  
}
