package com.company.exam_app.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnumValidator implements ConstraintValidator<ValidEnum,String> {

    Set<String> enumValues;
    @Override
    public void initialize(ValidEnum constraintAnnotation) {

        Stream<Enum<?>> stream = Arrays.stream(
                        constraintAnnotation.
                        enumClass().getEnumConstants());

        enumValues= stream.map(Enum::name)
                          .collect(Collectors.toSet());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return value == null || enumValues.contains(value);
    }
}
