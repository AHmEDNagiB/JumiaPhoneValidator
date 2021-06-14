package com.naguib.technicalTasks.JumiaPhoneValidator.services;

import com.naguib.technicalTasks.JumiaPhoneValidator.controller.dto.CountryDTO;
import com.naguib.technicalTasks.JumiaPhoneValidator.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class LookupsServiceImpl implements LookupsService {
    @Autowired
    CountryRepository countryRepository;

    @Override
    public List<CountryDTO> getAllCountries() {
        return countryRepository.getAllCountries()
                .stream().map(entity -> new CountryDTO(entity.getId(), entity.getName()))
                .collect(Collectors.toList());
    }
}
