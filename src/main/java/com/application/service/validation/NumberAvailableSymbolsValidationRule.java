package com.application.service.validation;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class NumberAvailableSymbolsValidationRule implements ValidationRule {

    @Override
    public void validate(String number) {
        if (!Pattern.matches("(\\+*)[0-9]+", number)) {
            throw new ValidationException("[ Please use only [ 0 - 9 ] and [ + ] before phone number ]");
        }

    }
}
