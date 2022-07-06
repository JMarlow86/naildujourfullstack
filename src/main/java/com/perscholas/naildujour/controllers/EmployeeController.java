package com.perscholas.naildujour.controllers;

import com.perscholas.naildujour.models.Beverage;
import com.perscholas.naildujour.models.Polish;

import com.perscholas.naildujour.services.BeverageService;
import com.perscholas.naildujour.services.PolishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class EmployeeController {

    PolishService polishService;
    BeverageService beverageService;



    @Autowired
    public EmployeeController(PolishService polishService, BeverageService beverageService){
        this.beverageService = beverageService;
        this.polishService = polishService;
    }

    @ModelAttribute("polish")
    public Polish polish(){

        return new Polish();
    }

    @ModelAttribute("beverage")
    public Beverage beverage(){

        return new Beverage();
    }

    @GetMapping("/delete")
    public String deleteInventory(Model model){
        List<Polish> polishes = polishService.findAll();
        List<Beverage> beverages = beverageService.findAll();
            model.addAttribute("polishes", polishes);
            model.addAttribute("beverages", beverages);

        return "delete";
    }

    @PostMapping("/deletePolish")
    public String deletePolish(@ModelAttribute("polish")Polish byePolish, Model model){

        List<Beverage> beverages = beverageService.findAll();
        Polish namePolish = polishService.findPolishByPolishId(byePolish.getPolishId());
        model.addAttribute("beverages", beverages);
        polishService.deletePolishByPolishId(byePolish.getPolishId());
        List<Polish> polishes = polishService.findAll();
        model.addAttribute("polishes", polishes);
        model.addAttribute("message","You have successfully deleted " + namePolish.getPolishName());

        return "delete";

    }

    @PostMapping("/deleteBeverage")
    public String deleteBeverage(@ModelAttribute("beverage")Beverage byeBeverage, Model model){

        List<Polish> polishes = polishService.findAll();
        Beverage nameBeverage = beverageService.findBeverageByName(byeBeverage.getName());
        model.addAttribute("polishes",polishes);
        beverageService.deleteBeverageByName(byeBeverage.getName());
        List<Beverage> beverages = beverageService.findAll();
        model.addAttribute("beverages", beverages);
        model.addAttribute("message", "You have successfully deleted " + nameBeverage.getName());

        return "delete";

    }

    @GetMapping("/polishinventory")
    public String managepolishInventory(Model model){
        return "polishinventory";
    }

    @PostMapping("/addpolish")
    public String addPolish(@ModelAttribute("polish")Polish newPolish, Model model){
        List<Polish> allPolishes = polishService.findAll();
            for (Polish polish : allPolishes) {
                if (polish.getPolishId() == newPolish.getPolishId() || polish.getPolishName().equals(newPolish.getPolishName())) {
                    model.addAttribute("message", "This polish already exists");

                return "polishinventory";
            }
        }
        polishService.saveOrUpdate(newPolish);
        model.addAttribute("message", "You've successfully added new polish");

            return "polishinventory";
    }

    @GetMapping("/beverageinventory")
    public String managebeverageInventory(){

        return "beverageinventory";
    }

    @PostMapping("/addbeverage")
    public String addBeverage(@ModelAttribute("beverage")Beverage newBeverage, Model model){
        List<Beverage> allBeverages = beverageService.findAll();
            for(Beverage beverage : allBeverages){
                if(beverage.getName().equals(newBeverage.getName())){
                 model.addAttribute("message","This Beverage already exists");

                return "beverageinventory";
            }
        }
        beverageService.saveOrUpdate(newBeverage);
        model.addAttribute("message","You've successfully added a new beverage");

        return "beverageinventory";
    }

}


