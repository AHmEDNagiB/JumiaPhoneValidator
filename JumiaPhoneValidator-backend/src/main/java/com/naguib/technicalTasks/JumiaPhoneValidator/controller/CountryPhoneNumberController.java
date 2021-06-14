package com.naguib.technicalTasks.JumiaPhoneValidator.controller;

import com.naguib.technicalTasks.JumiaPhoneValidator.controller.dto.CountryPhoneNumberDTO;
import com.naguib.technicalTasks.JumiaPhoneValidator.controller.dto.CountryPhoneNumberRequestDTO;
import com.naguib.technicalTasks.JumiaPhoneValidator.controller.dto.ResponseDTO;
import com.naguib.technicalTasks.JumiaPhoneValidator.services.CountryPhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/country-phone-number")
public class CountryPhoneNumberController {

    @Autowired
    CountryPhoneNumberService countryPhoneNumberService;

    @PostMapping
    public ResponseEntity gatAllCountryPhoneNumbers(@RequestBody @Valid CountryPhoneNumberRequestDTO requestDTO) {
        List<CountryPhoneNumberDTO> countryPhoneNumber = countryPhoneNumberService
                .getAllCountryPhoneNumberService(requestDTO);
        if (countryPhoneNumber == null || countryPhoneNumber.size() == 0) {
            return new ResponseEntity(new ResponseDTO<>("NO DATA FOUND", 204),
                    HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(new ResponseDTO<>(countryPhoneNumber), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity gat() {
        List<CountryPhoneNumberDTO> countryPhoneNumber = countryPhoneNumberService
                .getAllCountryPhoneNumberService(new CountryPhoneNumberRequestDTO());
        if (countryPhoneNumber == null || countryPhoneNumber.size() == 0) {
            return new ResponseEntity(new ResponseDTO<>("NO DATA FOUND", 204),
                    HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(new ResponseDTO<>(countryPhoneNumber), HttpStatus.OK);
    }



}
