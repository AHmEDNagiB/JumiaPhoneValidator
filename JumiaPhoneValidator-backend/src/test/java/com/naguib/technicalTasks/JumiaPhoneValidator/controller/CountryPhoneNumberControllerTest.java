package com.naguib.technicalTasks.JumiaPhoneValidator.controller;

import com.google.gson.Gson;
import com.naguib.technicalTasks.JumiaPhoneValidator.JumiaPhoneValidatorApplication;
import com.naguib.technicalTasks.JumiaPhoneValidator.controller.dto.CountryPhoneNumberRequestDTO;
import com.naguib.technicalTasks.JumiaPhoneValidator.services.CountryPhoneNumberService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = JumiaPhoneValidatorApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CountryPhoneNumberControllerTest {

    @Mock
    CountryPhoneNumberService countryPhoneNumberService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    Gson gson = new Gson();

    @InjectMocks
    @Autowired
    private CountryPhoneNumberController countryPhoneNumberController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void test_gatAllCountryPhoneNumbers_returnEmptyLIst() throws Exception {
        when(countryPhoneNumberService.getAllCountryPhoneNumberService(any())).thenReturn(new ArrayList<>());
        mockMvc.perform(post("/country-phone-number")
                .contentType(APPLICATION_JSON)
                .content(gson.toJson(new CountryPhoneNumberRequestDTO())))
                .andExpect(status().isNoContent()).andReturn();
    }

    @Test
    public void test_gatAllCountryPhoneNumbers_noBodyIsSent() throws Exception {
        when(countryPhoneNumberService.getAllCountryPhoneNumberService(any())).thenReturn(new ArrayList<>());
        mockMvc.perform(post("/country-phone-number")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isBadRequest()).andReturn();
    }

}