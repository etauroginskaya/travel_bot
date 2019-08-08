package com.gmail.etauroginskaya.bot.service.validator;

import com.gmail.etauroginskaya.bot.repository.CityRepository;
import com.gmail.etauroginskaya.bot.service.validator.annotations.CityIDExists;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CityIDExistsValidator implements ConstraintValidator<CityIDExists, String> {
    private final CityRepository cityRepository;

    public CityIDExistsValidator(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void initialize(CityIDExists constraint) {
    }

    @Override
    public boolean isValid(String id, ConstraintValidatorContext cxt) {
        if (id == null || id.matches("\\s+") || id == "" || cityRepository.findByID(Long.valueOf(id)) == null)
            return false;
        return true;
    }
}