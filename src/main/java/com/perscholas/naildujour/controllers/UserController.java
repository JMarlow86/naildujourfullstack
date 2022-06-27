package com.perscholas.naildujour.controllers;


import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller @Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping("app_user")

public class UserController {
    @RequestMapping({"/login"})
    public String showLogin(){
        return "";

    }
}
