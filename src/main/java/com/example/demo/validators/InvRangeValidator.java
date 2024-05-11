package com.example.demo.validators;

import com.example.demo.domain.Part;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class InvRangeValidator implements ConstraintValidator<ValidInvRange, Part> {

    @Override
    public void initialize(ValidInvRange constraint) {
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext context) {
        if (part == null) {
            return true; // Consider valid as there is no object to check validation against.
        }

        if (!(part.getInv() >= part.getMinInv() && part.getInv() <= part.getMaxInv())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Inventory must be between " + part.getMinInv() + " and " + part.getMaxInv())
                    .addPropertyNode("inv").addConstraintViolation();
            return false;
        }
        return true;
    }
}
