package com.application.service.validation;

import org.springframework.stereotype.Component;

@Component
public class NumberMaxLengthValidationRule implements ValidationRule {

    @Override
    public void validate(String number) {
        if (number.length() > 15) {
            throw new ValidationException("Your entered number length is too long. Max number length is [ 15 ] symbols." +
                    " Your current number is [ " + number.length() + " ] length.");
        }
    }
}
