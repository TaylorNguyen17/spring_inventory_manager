package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = InvRangeValidator.class)
@Target({ ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidInvRange {
    String message() default "Inventory must be within specified min and max values";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
