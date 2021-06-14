package com.naguib.technicalTasks.JumiaPhoneValidator.services;

import com.naguib.technicalTasks.JumiaPhoneValidator.controller.dto.CountryPhoneNumberDTO;
import com.naguib.technicalTasks.JumiaPhoneValidator.controller.dto.CountryPhoneNumberRequestDTO;

import java.util.List;

public interface CountryPhoneNumberService {
    List<CountryPhoneNumberDTO> getAllCountryPhoneNumberService(CountryPhoneNumberRequestDTO requestDTO);
}
