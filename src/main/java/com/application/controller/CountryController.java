package com.application.controller;

import com.application.domain.CountryEntity;
import com.application.dto.FindCountryResponse;
import com.application.service.IdentifyCountryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/find")
@RequiredArgsConstructor
public class CountryController {

    private final IdentifyCountryService service;

    @GetMapping(value = "/{number}")
    private FindCountryResponse findCountry(@PathVariable("number") String number) {
        return service.findCountryByPhoneNumber(number);
    }

}
