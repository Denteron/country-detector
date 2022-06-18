package com.application.service;

import com.application.domain.CountryEntity;
import com.application.dto.FindCountryResponse;
import com.application.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IdentifyCountryService {

    private CountryRepository repository;

    public FindCountryResponse findCountryByPhoneNumber(String number) {
        var result = repository.findWithQuery(number);
        return converter(resultsFilter(result));
    }

    private FindCountryResponse converter(String country) {
        var response = new FindCountryResponse();
        response.setCountry(country);
        return response;
    }

    private String resultsFilter (List<CountryEntity> entities) {
        var maxLengthResult = 0;
        var countryResult = "";
        for (CountryEntity entity : entities) {
            if (entity.getCode().length() > maxLengthResult) {
                maxLengthResult = entity.getCode().length();
                countryResult = entity.getCountry();
            }
        }
        return countryResult;

    }


}
