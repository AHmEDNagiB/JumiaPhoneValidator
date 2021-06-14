package com.naguib.technicalTasks.JumiaPhoneValidator.controller;

import com.naguib.technicalTasks.JumiaPhoneValidator.controller.dto.CountryDTO;
import com.naguib.technicalTasks.JumiaPhoneValidator.controller.dto.ResponseDTO;
import com.naguib.technicalTasks.JumiaPhoneValidator.services.LookupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/Lookups")
public class LookupsController {

    @Autowired
    LookupsService lookupsService;

    @GetMapping("/countries")
    public ResponseEntity gatAllCountryPhoneNumbers() {
        List<CountryDTO> countryPhoneNumber = lookupsService.getAllCountries();
        if (countryPhoneNumber == null || countryPhoneNumber.size() == 0) {
            return new ResponseEntity(new ResponseDTO<>("NO DATA FOUND", 204),
                    HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(new ResponseDTO<>(countryPhoneNumber), HttpStatus.OK);
    }


}
