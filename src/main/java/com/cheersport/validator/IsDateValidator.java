package com.cheersport.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.SimpleDateFormat;

public class IsDateValidator implements ConstraintValidator<IsDate, String> {

    private String pattern;

    @Override
    public void initialize(IsDate constraintAnnotation) {
        pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String date, ConstraintValidatorContext constraintValidatorContext) {
        try {
            new SimpleDateFormat(pattern).parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
