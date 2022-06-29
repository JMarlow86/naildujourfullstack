package com.perscholas.naildujour;

import com.perscholas.naildujour.data.BeverageRepository;
import com.perscholas.naildujour.models.Beverage;
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

    BeverageRepository beverageRepository;




    @Autowired
    public ApplicationCommandLineRunner(UserService userService, BeverageService beverageService, OrderService orderService, PolishService polishService, BeverageRepository beverageRepository) {
        this.userService = userService;
        this.beverageService = beverageService;
        this.orderService = orderService;
        this.polishService = polishService;
        this.beverageRepository = beverageRepository;

    }
    @PostConstruct
    public void postConstruct() { log.warn("============ Application CommandLine Runner ============"); }


    @Override
    public void run(String... args) throws Exception {

        beverageService.saveOrUpdate(new Beverage( "Wine", "alcoholic"));
        beverageService.saveOrUpdate(new Beverage( "water", "na"));

        userService.saveOrUpdate(new User("Jamie@gmail.com", "jamie", "2123338888","boss","she/her"));


    }
}
