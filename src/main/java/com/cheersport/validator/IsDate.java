package com.cheersport.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IsDateValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsDate {
    String message() default "Invalid date";
    String pattern();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
