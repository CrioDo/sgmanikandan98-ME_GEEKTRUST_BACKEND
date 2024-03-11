package com.geektrust.backend.entities;

public class Topup {

    private int device;
    private int months;

    public Topup(int device, int months) {
        this.device = device;
        this.months = months;
    }

    public int getDevice() {
        return device;
    }

    public void setDevice(int device) {
        this.device = device;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

   

    
   
    
}
