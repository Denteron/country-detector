package com.application.controller;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class},
        mergeMode = TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS)
class CountryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DatabaseSetup(value = "classpath:dbunit/find-country-dataset.xml")
    @DatabaseTearDown(value = "classpath:dbunit/find-country-dataset.xml")
    void shouldFindCountryIT() throws Exception {
        mockMvc.perform(get("/find/+123456789")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("+123456789"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.country").value("United States"));
    }

    @Test
    @DatabaseSetup(value = "classpath:dbunit/find-country-dataset.xml")
    @DatabaseTearDown(value = "classpath:dbunit/find-country-dataset.xml")
    void shouldNotFoundCountryIT() throws Exception {
        mockMvc.perform(get("/find/+9999999999")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("+9999999999"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.country").value("This phone number can't find any country"));
    }

    @Test
    @DatabaseSetup(value = "classpath:dbunit/find-country-dataset.xml")
    @DatabaseTearDown(value = "classpath:dbunit/find-country-dataset.xml")
    void shouldThrowExceptionWhenTryFindCountryIT() throws Exception {
        mockMvc.perform(get("/find/+dfdf99999999999999999dfjhfjhsdhfjgdsgfjsf")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("+dfdf99999999999999999dfjhfjhsdhfjgdsgfjsf"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.country").value("Please enter a valid phone number"))
                .andExpect(jsonPath("$.errors").isNotEmpty());
    }

}