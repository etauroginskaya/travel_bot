package com.gmail.etauroginskaya.bot.service;

import com.gmail.etauroginskaya.bot.service.model.CityDTO;

public interface CityService {
    void addCity(CityDTO cityDTO);

    CityDTO deleteCityById(Long id);

    void update(CityDTO cityDTO);

    String getDescriptionByName(String text);
}