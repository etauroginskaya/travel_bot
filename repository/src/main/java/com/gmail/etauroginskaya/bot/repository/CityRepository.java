package com.gmail.etauroginskaya.bot.repository;

import com.gmail.etauroginskaya.bot.repository.model.City;

public interface CityRepository {
    void persist(City city);

    void remove(City city);

    City findByID(Long id);

    boolean findByName(String name);

    City getByName(String name);

    void merge(City city);
}
