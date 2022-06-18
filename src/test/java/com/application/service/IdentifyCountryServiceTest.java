package com.application.service;

import com.application.domain.CountryEntity;
import com.application.dto.FindCountryResponse;
import com.application.repository.CountryRepository;
import com.application.service.validation.ValidationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class IdentifyCountryServiceTest {

    @Mock
    private CountryRepository repository;

    @Mock
    private ValidationService validationService;

    @InjectMocks
    private IdentifyCountryService service;


    @Test
    void shouldFindCountryByPhoneNumber() {
        when(repository.findCountryByCode("+123456789")).thenReturn(List.of(correctCountyEntity()));
        when(validationService.validate("+123456789")).thenReturn(List.of());
        var actualResult = service.findCountryByPhoneNumber("+123456789");
        var expectedResult = response();
        verify(repository).findCountryByCode("+123456789");
        assertEquals(actualResult, expectedResult);
    }

    @Test
    void shouldNotFindCountryByPhoneNumber() {
        when(repository.findCountryByCode("+999999999")).thenReturn(List.of(noCountyFound()));
        when(validationService.validate("+999999999")).thenReturn(List.of());
        var actualResult = service.findCountryByPhoneNumber("+999999999");
        var expectedResult = noCountryFoundResponse();
        verify(repository).findCountryByCode("+999999999");
        assertEquals(actualResult, expectedResult);
    }



    private FindCountryResponse response() {
        var response = new FindCountryResponse();
        response.setCountry("United States");
        return response;
    }

    private CountryEntity correctCountyEntity() {
        var country = new CountryEntity();
        country.setCountry("United States");
        country.setCode("+1");
        return country;
    }

    private CountryEntity noCountyFound() {
        var country = new CountryEntity();
        country.setCountry("");
        return country;
    }

    private FindCountryResponse noCountryFoundResponse() {
        var response = new FindCountryResponse();
        response.setCountry("This phone number can't find any country");
        return response;
    }
}