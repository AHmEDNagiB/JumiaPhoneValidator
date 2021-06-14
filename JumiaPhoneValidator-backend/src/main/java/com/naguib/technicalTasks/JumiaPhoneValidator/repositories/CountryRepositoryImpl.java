package com.naguib.technicalTasks.JumiaPhoneValidator.repositories;

import com.naguib.technicalTasks.JumiaPhoneValidator.entities.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryRepositoryImpl implements CountryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Country getCountryByCode(String countryCode) {
        try {
            List<Country> countries = jdbcTemplate.query("select * from countries where code like " + countryCode,
                    (resultSet, rowNum) -> new Country(resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("code"),
                            resultSet.getString("phone_number_pattern")));
            if (!countries.isEmpty())
                return countries.get(0);
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    @Override
    public List<Country> getAllCountries() {
        try {
            return jdbcTemplate.query("select * from countries",
                    (resultSet, rowNum) -> new Country(resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("code"),
                            resultSet.getString("phone_number_pattern")));
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

}
