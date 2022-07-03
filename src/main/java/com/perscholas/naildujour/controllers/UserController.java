package com.perscholas.naildujour.controllers;

import com.perscholas.naildujour.models.Beverage;
import com.perscholas.naildujour.models.Polish;
import com.perscholas.naildujour.models.User;
import com.perscholas.naildujour.services.BeverageService;
import com.perscholas.naildujour.services.PolishService;
import com.perscholas.naildujour.services.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@Controller
public class UserController {

    UserService userService;
    PolishService polishService;
    BeverageService beverageService;

    @Autowired
    public UserController(UserService userService, BeverageService beverageService, PolishService polishService) {
        this.userService = userService;
        this.beverageService = beverageService;
        this.polishService = polishService;
    }

    @ModelAttribute("user")
    public User user(){
        return new User();
        }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/getUsers")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @PostMapping("/findusername")
    public RedirectView findUserName(@RequestParam(required = false) String email, RedirectAttributes redirectAttributes) {
//        log.warn("email: " + email);
        try {
            redirectAttributes.addFlashAttribute("user", userService.findUserByEmail(email));
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        }
        redirectAttributes.addFlashAttribute("user_not_found", String.format("Username: %s not found!", email));
        return new RedirectView("/users");
    }
//   return new RedirectView("/users");




    @GetMapping("/saveupdateuser")
    public String saveUpdateUser(RedirectAttributes model, @ModelAttribute("user") User user) {
//        log.warn("Model student: " + user);
        userService.saveOrUpdate(user);
        model.addFlashAttribute("user", userService.findUserByEmail(user.getEmail()));
        return "usercreateupdate";
    }
    //This is saving users to database connected to Login.html
    @PostMapping("/adduser")
    public String submitForm(@ModelAttribute("user") User newUser, Model model) {
        List<User> allUsers = userService.findAll();
        for (User user : allUsers) {
            if(user.getEmail().equals(newUser.getEmail())){
                model.addAttribute("message", "User is already registered");
                return "login";
            }
        }
        newUser.setRole("customer");
        userService.saveOrUpdate(newUser);
        List<Polish> polishes = polishService.findAll();
        List<Beverage> beverages = beverageService.findAll();
        model.addAttribute("polishes", polishes);
        model.addAttribute("beverages", beverages);
        return "order";
    }

}


