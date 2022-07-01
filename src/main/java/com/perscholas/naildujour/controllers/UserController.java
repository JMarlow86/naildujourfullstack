package com.perscholas.naildujour.controllers;

import com.perscholas.naildujour.models.User;
import com.perscholas.naildujour.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller @Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
//@RequestMapping("app_user")

public class UserController {
    @RequestMapping({"/login"})
    public String showLogin(){
        return "";

    }

//    @GetMapping("/allUsers")
//    public List<User> findAllUsers(){
//        return UserService.findAll();
//    }
}
