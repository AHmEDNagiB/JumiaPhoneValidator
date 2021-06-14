package com.naguib.technicalTasks.JumiaPhoneValidator.controller.dto;

import javax.validation.constraints.Min;
import java.util.StringJoiner;

public class CountryPhoneNumberRequestDTO {
    @Min(10)
    private int pageSize = 10;
    private int pageNumber = 0;
    private String countryFilter;
    private String statusFilter;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getCountryFilter() {
        return countryFilter;
    }

    public void setCountryFilter(String countryFilter) {
        this.countryFilter = countryFilter;
    }

    public String getStatusFilter() {
        return statusFilter;
    }

    public void setStatusFilter(String statusFilter) {
        this.statusFilter = statusFilter;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CountryPhoneNumberRequestDTO.class.getSimpleName() + "[", "]")
                .add("pageSize=" + pageSize)
                .add("pageNumber=" + pageNumber)
                .add("countryFilter='" + countryFilter + "'")
                .add("StatusFilter=" + statusFilter)
                .toString();
    }
}
