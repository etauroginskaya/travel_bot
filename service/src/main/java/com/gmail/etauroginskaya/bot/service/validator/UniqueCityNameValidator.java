package com.gmail.etauroginskaya.bot.service.validator;

import com.gmail.etauroginskaya.bot.repository.CityRepository;
import com.gmail.etauroginskaya.bot.service.validator.annotations.UniqueCityName;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueCityNameValidator implements ConstraintValidator<UniqueCityName, String> {
    private final CityRepository cityRepository;

    public UniqueCityNameValidator(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void initialize(UniqueCityName constraint) {
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext cxt) {
        if (name == null || name.matches("\\s+") || name == "" || cityRepository.findByName(name))
            return false;
        return true;
    }
}