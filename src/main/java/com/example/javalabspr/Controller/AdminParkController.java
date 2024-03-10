package com.example.javalabspr.Controller;


import com.example.javalabspr.Entity.Park;
import com.example.javalabspr.data.ParkRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@Slf4j
public class AdminParkController {
    private final ParkRepository parkRepository;
    @Autowired
    public AdminParkController(
            ParkRepository parkRepository) {
        this.parkRepository = parkRepository;
    }

    @GetMapping("/adminpark/{id}")
    public String addParks(Model model,@PathVariable(name = "id") int id)
    {

        List<Park> parks = parkRepository.findByCityId(id);
        model.addAttribute("parks", parks);
        Park park = new Park();
        model.addAttribute("park", park);
        return "adminpark";
    }
    @PostMapping( "/adminpark/{id}")
    public String newpark(Model model, @ModelAttribute(value = "park") @Valid Park park, Errors errors){
        System.out.println(park.getCityid());
        if (errors.hasErrors()) {
            model.addAttribute("parks", parkRepository.findByCityId(park.getCityid()));
            return addParks(model, park.getCityid());
        }
        else {
            parkRepository.save(park);
            model.addAttribute("parks", parkRepository.findByCityId(park.getCityid()));
        }
        return addParks(model, park.getCityid());
    }
    @RequestMapping(value = "/deletepark/{id}")
    public String deleteRace(Model model,@PathVariable(name = "id") int id) {
       int cityid = parkRepository.findCityId(id);
        parkRepository.delete(id);

        return addParks(model,cityid);
    }
}
