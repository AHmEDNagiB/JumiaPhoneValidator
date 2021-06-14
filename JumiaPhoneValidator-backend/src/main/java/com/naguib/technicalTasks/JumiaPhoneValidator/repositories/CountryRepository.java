package com.naguib.technicalTasks.JumiaPhoneValidator.repositories;

import com.naguib.technicalTasks.JumiaPhoneValidator.entities.Country;

import java.util.List;

public interface CountryRepository {
    Country getCountryByCode(String countryCode);

    List<Country>  getAllCountries();
}
