package com.perscholas.naildujour;

import com.perscholas.naildujour.data.UserRepository;
import com.perscholas.naildujour.data.BeverageRepository;
import com.perscholas.naildujour.data.OrderRepository;
import com.perscholas.naildujour.data.PolishRepository;
import com.perscholas.naildujour.models.User;
import com.perscholas.naildujour.models.Beverage;
import com.perscholas.naildujour.models.Order;
import com.perscholas.naildujour.models.Polish;
import com.perscholas.naildujour.services.UserService;
import com.perscholas.naildujour.services.BeverageService;
import com.perscholas.naildujour.services.OrderService;
import com.perscholas.naildujour.services.PolishService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.NoSuchElementException;
@Component @Slf4j
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class ApplicationCommandLineRunner implements CommandLineRunner {

    UserService userService;

    BeverageService beverageService;

    OrderService orderService;

    PolishService polishService;

    UserRepository userRepository;

    BeverageRepository beverageRepository;

    OrderRepository orderRepository;

    PolishRepository polishRepository;

    @Autowired
    public ApplicationCommandLineRunner(UserService userService, BeverageService beverageService, OrderService orderService, PolishService polishService, UserRepository userRepository, BeverageRepository beverageRepository, OrderRepository orderRepository, PolishRepository polishRepository) {
        this.userService = userService;
        this.beverageService = beverageService;
        this.orderService = orderService;
        this.polishService = polishService;
        this.userRepository = userRepository;
        this.beverageRepository = beverageRepository;
        this.orderRepository = orderRepository;
        this.polishRepository = polishRepository;
    }
    @PostConstruct
    public void postConstruct() { log.warn("============ Application CommandLine Runner ============"); }


    @Override
    public void run(String... args) throws Exception {

        Beverage wine = new Beverage();
        wine.setName("white");
        wine.setType("alcoholic");

        beverageRepository.save(wine);


    }
}
