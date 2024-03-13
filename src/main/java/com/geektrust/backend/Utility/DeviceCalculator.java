package com.geektrust.backend.Utility;

public class DeviceCalculator {

    public static int findDeviceCount(String noOfDevice){

       if(noOfDevice.equals("FOUR_DEVICE")){
        return constant.FOUR_DEVICE;
       }
       
       else if(noOfDevice.equals("TEN_DEVICE")){
          return constant.TEN_DEVICE;
       }
       return constant.CONSTANT_ZERO;

    }

    }
    