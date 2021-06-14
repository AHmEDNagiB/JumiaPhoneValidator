package com.naguib.technicalTasks.JumiaPhoneValidator.services;

import com.naguib.technicalTasks.JumiaPhoneValidator.controller.dto.CountryDTO;
import java.util.List;


public interface LookupsService {
    List<CountryDTO> getAllCountries();
}
