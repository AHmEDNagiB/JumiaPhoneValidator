package com.naguib.technicalTasks.JumiaPhoneValidator.services;

import com.naguib.technicalTasks.JumiaPhoneValidator.controller.dto.CountryPhoneNumberDTO;
import com.naguib.technicalTasks.JumiaPhoneValidator.controller.dto.CountryPhoneNumberRequestDTO;
import com.naguib.technicalTasks.JumiaPhoneValidator.repositories.CountryPhoneNumberRepository;
import com.naguib.technicalTasks.JumiaPhoneValidator.utils.mappers.PhoneNumberToCountryPhoneNumberDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class CountryPhoneNumberServiceImpl implements CountryPhoneNumberService {

    @Autowired
    CountryPhoneNumberRepository countryPhoneNumberRepository;
    @Autowired
    PhoneNumberToCountryPhoneNumberDTOMapper countryPhoneNumberDTOMapper;

    @Override
    public List<CountryPhoneNumberDTO> getAllCountryPhoneNumberService(CountryPhoneNumberRequestDTO requestDTO) {
        String query = this.countryPhoneNumberRepository.buildSqlQuery(requestDTO);
        System.out.println("********* Query is :" + query);
        List<String> phoneNumbers = this.countryPhoneNumberRepository.getCountryPhoneNumbers(query);
        System.out.println("********* phoneNumbers are  :");
        System.out.println(phoneNumbers);
        List<CountryPhoneNumberDTO> phoneNumberDTOS = mapToCountryPhoneNumberDTO(phoneNumbers);
        return filterAndPaginate(phoneNumberDTOS, requestDTO);
    }


    private List<CountryPhoneNumberDTO> mapToCountryPhoneNumberDTO(List<String> phoneNumbers) {
        List<CountryPhoneNumberDTO> phoneNumberDTOS = new ArrayList<>();
        phoneNumbers.forEach(phoneNumber -> {
            // Regex to check valid phone number format (###) #########.
            String regex = "^\\(\\d{3}\\)\\s?.+";
            // Compile the ReGex
            Pattern pattern = Pattern.compile(regex);
            if (pattern.matcher(phoneNumber).matches()) {
                phoneNumberDTOS.add(countryPhoneNumberDTOMapper.getCountryPhoneNumberDTO(phoneNumber));
            } else {
                phoneNumberDTOS.add(new CountryPhoneNumberDTO(phoneNumber, false));
            }
        });
        return phoneNumberDTOS;
    }

    private List<CountryPhoneNumberDTO> filterAndPaginate(List<CountryPhoneNumberDTO> phoneNumberDTOS,
                                                          CountryPhoneNumberRequestDTO requestDTO) {
        List<CountryPhoneNumberDTO> filteredList;
        if (requestDTO.getCountryFilter() != null && requestDTO.getStatusFilter() != null) {
            filteredList = phoneNumberDTOS.stream().filter(dto ->
                    dto.getCountry().equals(requestDTO.getCountryFilter())
                            && (dto.isValid() + "").equals(requestDTO.getStatusFilter())).collect(Collectors.toList());
        } else if (requestDTO.getCountryFilter() != null) {
            filteredList = phoneNumberDTOS.stream().filter(dto ->
                    dto.getCountry().equals(requestDTO.getCountryFilter())).collect(Collectors.toList());

        } else if (requestDTO.getStatusFilter() != null) {
            filteredList = phoneNumberDTOS.stream().filter(dto -> (dto.isValid() + "").equals(requestDTO.getStatusFilter()))
                    .collect(Collectors.toList());
        } else {
            filteredList = phoneNumberDTOS;
        }
        return (filteredList.size() < requestDTO.getPageSize()) ? filteredList : filteredList.subList(requestDTO.getPageNumber() * requestDTO.getPageSize(),
                (requestDTO.getPageNumber() * requestDTO.getPageSize()) + requestDTO.getPageSize());
    }
}
