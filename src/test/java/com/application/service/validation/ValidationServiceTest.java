package com.application.service.validation;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ValidationServiceTest {


    private final ValidationService validationService = new ValidationService(
            List.of(
                    new NumberAvailableSymbolsValidationRule(),
                    new NumberMaxLengthValidationRule(),
                    new NumberMinLengthValidationRule()
            )
    );


    @Test
    void shouldDoNotThrowException() {
        var actualResult = validationService.validate("+123456789");
        var expectedResult = List.of();
        assertEquals(actualResult, expectedResult);
    }

    @Test
    void shouldThrowException() {
        var actualResult = validationService.validate("+1234567");
        var expectedResult = List.of(new CoreError("Your entered number length is too short. Minimal number length is [ 10 ] " +
                "symbols with country code. Your current number is [ 8 ] length."));
        assertEquals(actualResult, expectedResult);
    }
}