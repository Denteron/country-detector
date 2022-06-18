package com.application.dto;

import com.application.domain.CountryEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class FindCountryResponse {

    private String country;
}