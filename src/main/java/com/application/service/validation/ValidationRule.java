package com.application.service.validation;

public interface ValidationRule {

    void validate(String number);

    default void nullDetector(String number) {
        if (number == null) {
            throw new ValidationException("You need enter a phone number");
        }
    }


}
