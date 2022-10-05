package ony.code.controllers;


import ony.code.dto.City;
import ony.code.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@Controller

public class MainController {

    CityService cityService;

    @Autowired
    public MainController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/game")
    public String gamePage(@ModelAttribute("city") City city, Model model){
        System.out.println(city.getTitle());
        model.addAttribute("message", cityService.generateCity(city));
        return "gamepage";
    }



}
