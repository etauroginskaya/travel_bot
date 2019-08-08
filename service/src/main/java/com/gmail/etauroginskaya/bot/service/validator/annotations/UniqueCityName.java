package com.gmail.etauroginskaya.bot.service.validator.annotations;

import com.gmail.etauroginskaya.bot.service.validator.UniqueCityNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = UniqueCityNameValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueCityName {
    String message() default "city with this name exists or not contain value";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}