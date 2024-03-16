package com.geektrust.backend.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import com.geektrust.backend.Utility.constant;
import com.geektrust.backend.entities.Category;

public class RenewalReminder {

    private Category category;
    private LocalDate renewalDate;


    public RenewalReminder(Category category, LocalDate renewalDate) {
        this.category = category;
        this.renewalDate = renewalDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDate getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(LocalDate renewalDate) {
        this.renewalDate = renewalDate;
    }

    @Override
    public String toString() {
        return "RENEWAL_REMINDER " + category.getPlanCategory() + " " + DateTimeFormatter.ofPattern(constant.DATE_PATTERN).format(renewalDate);
    }

    

    

    
    

    
}
