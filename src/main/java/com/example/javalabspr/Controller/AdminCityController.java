package com.example.javalabspr.Controller;

import com.example.javalabspr.Entity.City;
import com.example.javalabspr.data.CityRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Slf4j
public class AdminCityController {
    private final CityRepository cityRepository;
    @Autowired
    public AdminCityController(
            CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
    @GetMapping("/admincity")
    public String addCities(Model model)
    {
        List<City> cities = cityRepository.findAll();
        model.addAttribute("cities", cities);
        City city = new City();
        model.addAttribute("city", city);
        return "admincity";
    }
    @PostMapping( "/admincity")
    public String newcity(Model model,@ModelAttribute(value = "city") @Valid City city, Errors errors){

        if (errors.hasErrors()) {
            model.addAttribute("cities", cityRepository.findAll());
            return "admincity";
        }
        else {
            cityRepository.save(city);

        }
        return addCities(model);
    }
    @RequestMapping(value = "/deletecity/{id}")
    public String deleteRace(Model model,@PathVariable(name = "id") int id) {
        cityRepository.delete(id);

        return addCities(model);
    }
}
