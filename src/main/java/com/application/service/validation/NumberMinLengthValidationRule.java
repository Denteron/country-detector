package com.application.service.validation;

import org.springframework.stereotype.Component;

@Component
public class NumberMinLengthValidationRule implements ValidationRule {

    @Override
    public void validate(String number) {
        if (number.length() < 10) {
            throw new ValidationException("Your entered number length is too short. Minimal number length is [ 10 ] " +
                    "symbols with country code. Your current number is [ " + number.length() + " ] length.");
        }

    }
}
