package com.geektrust.backend.entities;


public class Category {

    private String planCategory;
    private String planName;
    private String renewalDate;

    public Category(String planCategory, String planName, String renewalDate) {
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

    public String getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(String renewalDate) {
        this.renewalDate = renewalDate;
    }
  
}
