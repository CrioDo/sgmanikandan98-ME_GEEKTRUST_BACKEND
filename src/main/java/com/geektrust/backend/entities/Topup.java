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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + device;
        result = prime * result + months;
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
        Topup other = (Topup) obj;
        if (device != other.device)
            return false;
        if (months != other.months)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Topup [device=" + device + ", months=" + months + "]";
    }

    
   
    
}
