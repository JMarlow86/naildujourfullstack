package com.perscholas.naildujour.controllers;

import com.perscholas.naildujour.models.Beverage;
import com.perscholas.naildujour.models.Order;
import com.perscholas.naildujour.models.Polish;
import com.perscholas.naildujour.services.BeverageService;
import com.perscholas.naildujour.services.PolishService;
import com.perscholas.naildujour.services.OrderService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import java.util.HashSet;
import java.util.Set;
import java.util.List;


@Controller
public class OrderController {

    OrderService orderService;
    PolishService polishService;

    BeverageService beverageService;

    @Autowired
    public OrderController(OrderService orderService, PolishService polishService, BeverageService beverageService) {
        this.orderService = orderService;
        this.polishService = polishService;
        this.beverageService = beverageService;
    }

    //returns order form view
    @GetMapping("/order")
    public String makeOrder(Model model){
        List<Polish> polishes = polishService.findAll();
        List<Beverage> beverages = beverageService.findAll();
        model.addAttribute("polishes", polishes);
        model.addAttribute("beverages", beverages);
        return "order";
}


}
