package com.example.javalabspr.data;

import com.example.javalabspr.Entity.City;
import com.example.javalabspr.Entity.Park;

import java.util.List;

public interface ParkRepository {
    List findAll();
    Park findById(int id);
    List findByCityId(int id);
    Park save(Park park);
    void delete(int id);
    int findCityId(int id);
    void update(Park park);
}
