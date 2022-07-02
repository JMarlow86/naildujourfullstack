package com.perscholas.naildujour.controllers;

import com.perscholas.naildujour.models.Polish;
import com.perscholas.naildujour.services.PolishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "http://localhost:8080")

public class PolishController {

    PolishService polishService;

    @Autowired
    public PolishController(PolishService polishService) {
        this.polishService = polishService;

    }
    @GetMapping("/findallpolish")
    public List<Polish> getAllPolish() {
        return polishService.findAll();
    }

}

