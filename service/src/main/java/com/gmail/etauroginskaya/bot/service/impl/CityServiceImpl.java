package com.gmail.etauroginskaya.bot.service.impl;

import com.gmail.etauroginskaya.bot.repository.CityRepository;
import com.gmail.etauroginskaya.bot.repository.model.City;
import com.gmail.etauroginskaya.bot.service.CityService;
import com.gmail.etauroginskaya.bot.service.model.CityDTO;
import com.gmail.etauroginskaya.bot.service.converter.CityConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final CityConverter cityConverter;

    public CityServiceImpl(CityRepository cityRepository, CityConverter cityConverter) {
        this.cityRepository = cityRepository;
        this.cityConverter = cityConverter;
    }

    @Override
    @Transactional
    public void addCity(CityDTO cityDTO) {
        cityRepository.persist(cityConverter.fromDTO(cityDTO));
    }

    @Override
    @Transactional
    public CityDTO deleteCityById(Long id) {
        City city = cityRepository.findByID(id);
        CityDTO cityDTO = null;
        if (city != null) {
            cityRepository.remove(city);
            cityDTO = cityConverter.toDTO(city);
        }
        return cityDTO;
    }

    @Override
    @Transactional
    public void update(CityDTO cityDTO) {
        cityRepository.merge(cityConverter.fromDTO(cityDTO));
    }

    @Override
    public String getDescriptionByName(String text) {
        City city = cityRepository.getByName(text);
        if (city != null)
            return city.getDescription();
        return "Information about this city is missing.";
    }
}