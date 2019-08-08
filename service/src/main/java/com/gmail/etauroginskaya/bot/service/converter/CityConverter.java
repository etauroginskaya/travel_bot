package com.gmail.etauroginskaya.bot.service.converter;

import com.gmail.etauroginskaya.bot.repository.model.City;
import com.gmail.etauroginskaya.bot.service.model.CityDTO;

public interface CityConverter {
    CityDTO toDTO(City city);

    City fromDTO(CityDTO cityDTO);
}
