package com.example.javalabspr.Controller;
import com.example.javalabspr.Entity.City;
import com.example.javalabspr.data.CityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@Slf4j
public class CityEditController {

    private final CityRepository cityRepository;
    private final AdminCityController adminCityController;
    @Autowired
    public CityEditController(CityRepository cityRepository, AdminCityController adminCityController) {
        this.cityRepository = cityRepository;
        this.adminCityController = adminCityController;
    }


    @RequestMapping("/cityedit/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("editcity");
        City city = cityRepository.findById(id);
        mav.addObject("city",city);
        return mav;
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Model model, @ModelAttribute("city") City city) {
        cityRepository.update(city);
        return adminCityController.addCities(model) ;
    }
}
