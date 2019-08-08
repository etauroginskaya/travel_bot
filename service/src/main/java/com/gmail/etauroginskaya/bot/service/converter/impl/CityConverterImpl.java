package com.gmail.etauroginskaya.bot.service.converter.impl;

import com.gmail.etauroginskaya.bot.service.converter.CityConverter;
import com.gmail.etauroginskaya.bot.repository.model.City;
import com.gmail.etauroginskaya.bot.service.model.CityDTO;
import org.springframework.stereotype.Component;

@Component
public class CityConverterImpl implements CityConverter {
    @Override
    public CityDTO toDTO(City city) {
        CityDTO cityDTO = new CityDTO();
        cityDTO.setName(city.getName());
        cityDTO.setDescription(city.getDescription());
        return cityDTO;
    }

    @Override
    public City fromDTO(CityDTO cityDTO) {
        City city = new City();
        if (cityDTO.getId() != null)
            city.setId(Long.valueOf(cityDTO.getId()));
        city.setName(cityDTO.getName());
        city.setDescription(cityDTO.getDescription());
        return city;
    }
}