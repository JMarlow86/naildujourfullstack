package com.perscholas.naildujour.controllers;

import com.perscholas.naildujour.models.Customer;
import com.perscholas.naildujour.models.Employee;
import com.perscholas.naildujour.models.Beverage;
import com.perscholas.naildujour.models.Polish;
import com.perscholas.naildujour.services.CustomerService;
import com.perscholas.naildujour.services.EmployeeService;
import com.perscholas.naildujour.services.BeverageService;
import com.perscholas.naildujour.services.PolishService;
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
@RequestMapping("customer")

public class CustomerController {
}
