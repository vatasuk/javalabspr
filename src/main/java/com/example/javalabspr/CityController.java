package com.example.javalabspr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class CityController {
    @GetMapping("/city")
    public String home() {
        return "city";
    }
}