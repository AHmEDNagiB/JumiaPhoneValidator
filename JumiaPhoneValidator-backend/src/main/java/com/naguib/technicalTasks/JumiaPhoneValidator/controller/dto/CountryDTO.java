package com.naguib.technicalTasks.JumiaPhoneValidator.controller.dto;

public class  CountryDTO {
    private int id;
    private String name;


    public CountryDTO() {
    }

    public CountryDTO(int id, String name) {
        this.id = id;
        this.name = name;
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


}
