package com.perscholas.naildujour.controllers;

import com.perscholas.naildujour.models.Beverage;
import com.perscholas.naildujour.models.Order;
import com.perscholas.naildujour.models.Polish;
import com.perscholas.naildujour.models.User;
import com.perscholas.naildujour.services.BeverageService;
import com.perscholas.naildujour.services.PolishService;
import com.perscholas.naildujour.services.OrderService;
import com.perscholas.naildujour.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
public class OrderController {

    OrderService orderService;
    PolishService polishService;

    UserService userService;

    BeverageService beverageService;

    @Autowired
    public OrderController(OrderService orderService, PolishService polishService, BeverageService beverageService, UserService userService) {
        this.orderService = orderService;
        this.polishService = polishService;
        this.beverageService = beverageService;
        this.userService = userService;
    }
    @ModelAttribute("order")
    public Order order(){

        return new Order();
    }

    //returns order form view
    @GetMapping("/order")
    public String showOrder(Model model){
    //Makes List of all polishes and beverages to auto-populate drop down list
        List<Polish> polishes = polishService.findAll();
        List<Beverage> beverages = beverageService.findAll();
            model.addAttribute("polishes", polishes);
            model.addAttribute("beverages", beverages);

        return "order";
    }

    //POSTMAPPING LOGIC IS NOT WORKING TO PROMPT USER TO REGISTER IF NOT RECOGNIZED IN DATABASE. CREATES ORDER NOMATTER WHAT
    @PostMapping("/makeorder")
    public String makeOrder(@ModelAttribute("order")Order newOrder, Model model){
        List<User> savedUsers = userService.findAll();
        Boolean isInSystem = false;
            for (User user : savedUsers){
                if(user.getEmail().equals(newOrder.getUserEmail())){
                    isInSystem = true;

                    continue; //makes it faster by exiting the loop when condition is met
            }
        }
        if (isInSystem = false){
            model.addAttribute("message","User does not exist, please register");

            return "order";
        }
        orderService.saveOrUpdate(newOrder);
        List <User> currectUser = userService.findAll();
            model.addAttribute("currentUser", currectUser);

        return "success";
    }


}
