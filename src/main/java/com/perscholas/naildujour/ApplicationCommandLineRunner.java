package com.perscholas.naildujour;

import com.perscholas.naildujour.data.BeverageRepository;
import com.perscholas.naildujour.models.Beverage;
import com.perscholas.naildujour.models.Polish;
import com.perscholas.naildujour.models.User;
import com.perscholas.naildujour.services.BeverageService;
import com.perscholas.naildujour.services.OrderService;
import com.perscholas.naildujour.services.PolishService;
import com.perscholas.naildujour.services.UserService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component @Slf4j
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class ApplicationCommandLineRunner implements CommandLineRunner {

    UserService userService;

    BeverageService beverageService;

    OrderService orderService;

    PolishService polishService;






    @Autowired
    public ApplicationCommandLineRunner(UserService userService, BeverageService beverageService, OrderService orderService, PolishService polishService) {
        this.userService = userService;
        this.beverageService = beverageService;
        this.orderService = orderService;
        this.polishService = polishService;


    }
    @PostConstruct
    public void postConstruct() { log.warn("============ Application CommandLine Runner ============"); }


    @Override
    public void run(String... args) throws Exception {

        beverageService.saveOrUpdate(new Beverage( "Red Wine", "alcoholic"));
        beverageService.saveOrUpdate(new Beverage( "Purple Drank", "alcoholic"));
        beverageService.saveOrUpdate(new Beverage( "Rose Wine", "alcoholic"));
        beverageService.saveOrUpdate(new Beverage( "White Wine", "alcoholic"));
        beverageService.saveOrUpdate(new Beverage( "Prosecco", "alcoholic"));
        beverageService.saveOrUpdate(new Beverage( "Pale Ale", "alcoholic"));
        beverageService.saveOrUpdate(new Beverage( "Sparkling Water", "na"));
        beverageService.saveOrUpdate(new Beverage( "Still Water", "na"));
        beverageService.saveOrUpdate(new Beverage( "Fresh Juice", "na"));
        beverageService.saveOrUpdate(new Beverage( "Coke", "na"));


        userService.saveOrUpdate(new User("Jamie@gmail.com", "jamie", "2123338888","boss","she/her"));
        userService.saveOrUpdate(new User("Mira@gmail.com", "Mira", "21237896888","head bitch","she/her"));
        userService.saveOrUpdate(new User("Goliath@gmail.com", "Goliath", "2003338888","customer","he/him"));


        polishService.saveOrUpdate(new Polish(1,"Ruby on Rails"));
        polishService.saveOrUpdate(new Polish(2,"Oracle Orange"));
        polishService.saveOrUpdate(new Polish(3,"Yaml Yellow"));
        polishService.saveOrUpdate(new Polish(4,"Google Green"));
        polishService.saveOrUpdate(new Polish(5,"Python Purple"));
        polishService.saveOrUpdate(new Polish(6,"OOP-ink"));
        polishService.saveOrUpdate(new Polish(7,"Intelli-grey"));
        polishService.saveOrUpdate(new Polish(8,"Maven Mauve"));
        polishService.saveOrUpdate(new Polish(9,"_build Blue"));
    }
}
