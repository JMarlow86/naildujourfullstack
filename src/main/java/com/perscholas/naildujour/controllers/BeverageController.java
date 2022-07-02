package com.perscholas.naildujour.controllers;

import com.perscholas.naildujour.models.Beverage;
import com.perscholas.naildujour.services.BeverageService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "http://localhost:8080")




public class BeverageController {

    BeverageService beverageService;

    @Autowired
    public BeverageController(BeverageService beverageService) {

        this.beverageService = beverageService;
    }

    //findallbeverage working in localhost
    @GetMapping("/findallbeverage")
    public List<Beverage> getAllBeverages() {

        return beverageService.findAll();
    }

    @GetMapping(value="/bevtype")
    public List<Beverage> findBeveragesByType(@RequestParam String type) {
        return beverageService.findBeveragesByType(type);
    }

    @GetMapping(value="/bevname")
    public List <Beverage> findBeverageByName(@RequestParam String name) {

        return (List<Beverage>) beverageService.findBeverageByName(name);
    }

}












