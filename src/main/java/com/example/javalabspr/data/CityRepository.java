package com.example.javalabspr.data;

import com.example.javalabspr.Entity.City;

import java.util.List;

public interface CityRepository {
    List findAll();
    City findById(int id);
    City save(City city);
    void delete(int id);
    void update(City city);
}
