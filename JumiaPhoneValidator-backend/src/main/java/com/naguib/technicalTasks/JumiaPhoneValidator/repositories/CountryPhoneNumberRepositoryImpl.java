package com.naguib.technicalTasks.JumiaPhoneValidator.repositories;

import com.naguib.technicalTasks.JumiaPhoneValidator.controller.dto.CountryPhoneNumberRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryPhoneNumberRepositoryImpl implements CountryPhoneNumberRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String buildSqlQuery(CountryPhoneNumberRequestDTO requestDTO) {
        return new StringBuilder("SELECT phone FROM customer")
//                .append(" limit ")
//                .append(requestDTO.getPageSize())
//                .append(" offset ")
//                .append(requestDTO.getPageSize() * requestDTO.getPageNumber())
                .toString();
    }
    @Override
    public List<String> getCountryPhoneNumbers(String query) {
        try {
            return jdbcTemplate.query(query,
                    (resultSet, rowNum) -> resultSet.getString("phone"));
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
