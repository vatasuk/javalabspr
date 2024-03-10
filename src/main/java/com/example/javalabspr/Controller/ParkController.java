package com.example.javalabspr.Controller;

import com.example.javalabspr.Entity.Park;
import com.example.javalabspr.data.ParkRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@Slf4j
public class ParkController {
    private final ParkRepository parkRepository;

    @Autowired
    public ParkController(
            ParkRepository parkRepository) {
        this.parkRepository = parkRepository;
    }

    @GetMapping(value = "/city/{id}")
    public String ShowParks(Model model,@PathVariable(name = "id") int id) {
        List<Park> parks = parkRepository.findByCityId(id);
        model.addAttribute("parks", parks);
        return "park";

    }
}