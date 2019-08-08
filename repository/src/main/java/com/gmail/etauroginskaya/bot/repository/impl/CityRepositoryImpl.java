package com.gmail.etauroginskaya.bot.repository.impl;

import com.gmail.etauroginskaya.bot.repository.CityRepository;
import com.gmail.etauroginskaya.bot.repository.model.City;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CityRepositoryImpl implements CityRepository {
    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public void persist(City city) {
        entityManager.persist(city);
    }

    @Override
    public void remove(City city) {
        entityManager.remove(city);
    }

    @Override
    public City findByID(Long id) {
        return entityManager.find(City.class, id);
    }

    @Override
    public boolean findByName(String name) {
        Query query = entityManager.createQuery("FROM City AS C WHERE C.name=:name")
                .setParameter("name", name);
        return !query.getResultList().isEmpty();
    }

    @Override
    public City getByName(String name) {
        Query query = entityManager.createQuery("FROM City AS C WHERE C.name=:name")
                .setParameter("name", name);
        List<Object> result = query.getResultList();
        if (result.isEmpty())
            return null;
        return (City) result.get(0);
    }

    @Override
    public void merge(City city) {
        entityManager.merge(city);
    }
}