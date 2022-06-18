package com.application.service.validation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ValidationService {

    private final List<ValidationRule> validationRules;

    public List<CoreError> validate(String number) {
        List<CoreError> errors = new ArrayList<>();
        if (number.equals(" ")) {
            errors.add(new CoreError("[ You need enter a phone number ]"));
            return errors;
        }
        return validationRules.stream()
                .map(rule -> mapError(rule, number))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private CoreError mapError(ValidationRule rule, String number) {
        try {
            rule.validate(number);
        } catch (ValidationException e) {
            return new CoreError(e.getMessage());
        }
        return null;
    }


}
