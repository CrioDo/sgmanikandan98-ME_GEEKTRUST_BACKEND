package com.geektrust.backend.entities;

import java.time.LocalDate;

public class Category {

    private String planCategory;
    private String planName;
    private LocalDate renewalDate;
    
    public Category(String planCategory, String planName) {
        this.planCategory = planCategory;
        this.planName = planName;
    }

    public Category(String planCategory,String planName, LocalDate renewalDate) {
        this.planCategory = planCategory;
        this.planName = planName;
        this.renewalDate = renewalDate;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((planCategory == null) ? 0 : planCategory.hashCode());
        result = prime * result + ((planName == null) ? 0 : planName.hashCode());
        result = prime * result + ((renewalDate == null) ? 0 : renewalDate.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Category other = (Category) obj;
        if (planCategory == null) {
            if (other.planCategory != null)
                return false;
        } else if (!planCategory.equals(other.planCategory))
            return false;
        if (planName == null) {
            if (other.planName != null)
                return false;
        } else if (!planName.equals(other.planName))
            return false;
        if (renewalDate == null) {
            if (other.renewalDate != null)
                return false;
        } else if (!renewalDate.equals(other.renewalDate))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Category [planCategory=" + planCategory + ", planName=" + planName
                + ", renewalDate=" + renewalDate + "]";
    }
    
    
    
    
    
}
