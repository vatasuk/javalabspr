package com.example.javalabspr.Controller;


import com.example.javalabspr.Entity.City;
import com.example.javalabspr.data.CityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
public class CityController {

    private final CityRepository cityRepository;
    @Autowired
    public CityController(
            CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @RequestMapping("/city")
    public String addCities(Model model)
    {
        List<City> cities = cityRepository.findAll();
        model.addAttribute("cities", cities);
        return "city";

    }


}