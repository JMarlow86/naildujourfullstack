package com.perscholas.naildujour.controllers;

import com.perscholas.naildujour.models.Beverage;
import com.perscholas.naildujour.models.User;
import com.perscholas.naildujour.models.Order;

import com.perscholas.naildujour.services.UserService;
import com.perscholas.naildujour.services.BeverageService;
import com.perscholas.naildujour.services.OrderService;



import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller @Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping("beverage")

public class BeverageController {


    BeverageService beverageService;

    OrderService orderService;



    @Autowired
    public BeverageController(BeverageService beverageService, OrderService orderService) {

        this.beverageService = beverageService;
        this.orderService = orderService;

    }

    @GetMapping
    public String getAllBeverages(Model model) {
    log.info(beverageService.findByType("alcholic").toString());
        model.addAttribute("beverage", beverageService.findAll());

        return "beverage";
    }
    }













