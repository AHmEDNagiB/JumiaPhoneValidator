package com.naguib.technicalTasks.JumiaPhoneValidator.controller.dto;

import java.util.StringJoiner;

public class CountryPhoneNumberDTO {
    private String number;
    private String country;
    private String countryCode;
    private boolean valid;

    public CountryPhoneNumberDTO() {
    }

    public CountryPhoneNumberDTO(String number, String country, String countryCode, boolean valid) {
        this.number = number;
        this.country = country;
        this.countryCode = countryCode;
        this.valid = valid;
    }

    public CountryPhoneNumberDTO(String number, boolean valid) {
        this.number = number;
        this.valid = valid;
        this.number = number;
        this.country = "--";
        this.countryCode = "--";
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", CountryPhoneNumberDTO.class.getSimpleName() + "[", "]")
                .add("number='" + number + "'")
                .add("country='" + country + "'")
                .add("countryCode='" + countryCode + "'")
                .add("valid=" + valid)
                .toString();
    }
}
