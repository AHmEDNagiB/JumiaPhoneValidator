package com.naguib.technicalTasks.JumiaPhoneValidator.utils;

public class Utils {
    public static String getCountryCode(String countryCode){
        return countryCode.substring(1,countryCode.length()-1);
    }
}
