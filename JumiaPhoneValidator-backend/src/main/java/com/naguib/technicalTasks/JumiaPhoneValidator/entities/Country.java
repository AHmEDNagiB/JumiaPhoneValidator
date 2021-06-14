package com.naguib.technicalTasks.JumiaPhoneValidator.entities;

public class Country {
    private int id;
    private String name;
    private String code;
    private String phoneNumberPattern;

    public Country() {
    }

    public Country(int id, String name, String code, String phoneNumberPattern) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.phoneNumberPattern = phoneNumberPattern;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPhoneNumberPattern() {
        return phoneNumberPattern;
    }

    public void setPhoneNumberPattern(String phoneNumberPattern) {
        this.phoneNumberPattern = phoneNumberPattern;
    }
}
