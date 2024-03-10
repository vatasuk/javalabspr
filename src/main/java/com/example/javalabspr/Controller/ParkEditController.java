package com.example.javalabspr.Controller;

import com.example.javalabspr.Entity.Park;
import com.example.javalabspr.data.ParkRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
@Slf4j
public class ParkEditController {
    private final ParkRepository parkRepository;
    private final AdminParkController adminParkController;
    @Autowired
    public ParkEditController(ParkRepository parkRepository, AdminParkController adminParkController) {
        this.parkRepository = parkRepository;
        this.adminParkController = adminParkController;
    }


    @RequestMapping("/parkedit/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("editpark");
        Park park = parkRepository.findById(id);
        mav.addObject("park",park);
        return mav;
    }
    @RequestMapping(value = "/updatepark", method = RequestMethod.POST)
    public String update(Model model, @ModelAttribute("park") Park park) {
        parkRepository.update(park);
        return adminParkController.addParks(model, park.getCityid()) ;
    }
}
