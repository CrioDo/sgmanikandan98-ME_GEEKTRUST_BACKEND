package com.geektrust.backend.Utility;

public class DeviceCalculator {

    public static int findDeviceCount(String noOfDevice){

        switch(noOfDevice){

            case "ONE_DEVICE":
                return 1;
            case "TWO_DEVICE":
                return 2;
            case "THREE_DEVICE":
                return 3;
            case "FOUR_DEVICE":
                return 4;
            case "FIVE_DEVICE":
                return 5;
            case "SIX_DEVICE":
                return 6;
            case "SEVEN_DEVICE":
                return 7;
            case "EIGHT_DEVICE":
                return 8;
            case "NINE_DEVICE":
                return 9;
            case "TEN_DEVICE":
                return 10;     
        }
        return 0;

    }

    }
    