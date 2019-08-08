package com.gmail.etauroginskaya.bot.service.validator.annotations;

import com.gmail.etauroginskaya.bot.service.validator.CityIDExistsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = CityIDExistsValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CityIDExists {
    String message() default "city with this id doesn't exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}