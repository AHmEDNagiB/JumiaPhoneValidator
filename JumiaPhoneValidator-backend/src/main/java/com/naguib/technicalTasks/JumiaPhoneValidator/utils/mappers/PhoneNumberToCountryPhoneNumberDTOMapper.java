package com.naguib.technicalTasks.JumiaPhoneValidator.utils.mappers;

import com.naguib.technicalTasks.JumiaPhoneValidator.controller.dto.CountryPhoneNumberDTO;
import com.naguib.technicalTasks.JumiaPhoneValidator.entities.Country;
import com.naguib.technicalTasks.JumiaPhoneValidator.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

import static com.naguib.technicalTasks.JumiaPhoneValidator.utils.Utils.getCountryCode;

@Service
public class PhoneNumberToCountryPhoneNumberDTOMapper {
    @Autowired
    CountryRepository countryRepository;

    public CountryPhoneNumberDTO getCountryPhoneNumberDTO(String phoneNumber) {
        String[] split = phoneNumber.split("\\s");
        String countryCode = getCountryCode(split[0]);
        String exactPhoneNumber = getCountryCode(split[1]);
        Country country = countryRepository.getCountryByCode(countryCode);
        if (country == null) {
            return new CountryPhoneNumberDTO(phoneNumber, false);
        }
        // Compile the ReGex
        Pattern pattern = Pattern.compile(country.getPhoneNumberPattern());
        if (pattern.matcher(phoneNumber).matches()) {
            return new CountryPhoneNumberDTO(phoneNumber, country.getName(), country.getCode(), true);
        }
        return new CountryPhoneNumberDTO(phoneNumber, country.getName(), country.getCode(), false);
    }
}
