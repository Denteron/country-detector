package com.application.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CountryDTO {

    private Integer id;
    private String countryCode;
    private String countryName;
}
