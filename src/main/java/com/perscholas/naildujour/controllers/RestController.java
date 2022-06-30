package com.perscholas.naildujour.controllers;

import com.perscholas.naildujour.models.Beverage;
import com.perscholas.naildujour.services.BeverageService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "http://localhost:8080")
//@Controller
//@Slf4j
//@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)




public class RestController {

    BeverageService beverageService;

    @Autowired
    public RestController(BeverageService beverageService) {

        this.beverageService = beverageService;
    }

    //finallbeverage working in localhost
    @GetMapping("/findallbeverage")
    public List<Beverage> getAllBeverages() {

        return beverageService.findAll();
    }

    @GetMapping(value="/bevtype")
    public List<Beverage> findBeveragesByType(@RequestParam String type) {
        return beverageService.findBeveragesByType(type);
    }


//    @GetMapping(value="/vintage")
//    public Iterable<Wine> findByVintage(@RequestParam String vintage) {
//        return wineService.findWinesByVintage(vintage);
//    }
}












