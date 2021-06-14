package com.naguib.technicalTasks.JumiaPhoneValidator.repositories;

import com.naguib.technicalTasks.JumiaPhoneValidator.controller.dto.CountryPhoneNumberRequestDTO;

import java.util.List;

public interface CountryPhoneNumberRepository {
    String buildSqlQuery(CountryPhoneNumberRequestDTO requestDTO);
    List<String> getCountryPhoneNumbers(String query);
}
