package com.perscholas.naildujour.services;

import com.perscholas.naildujour.data.UserRepository;
import com.perscholas.naildujour.data.BeverageRepository;
import com.perscholas.naildujour.data.OrderRepository;
import com.perscholas.naildujour.data.PolishRepository;
import com.perscholas.naildujour.models.User;
import com.perscholas.naildujour.models.Beverage;
import com.perscholas.naildujour.models.Order;
import com.perscholas.naildujour.models.Polish;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;


@Service @Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@Transactional(rollbackOn = {DataAccessException.class})
public class BeverageService {

//    UserRepository userRepository;

    BeverageRepository beverageRepository;

//    OrderRepository orderRepository;


    @Autowired
    public BeverageService(BeverageRepository beverageRepository) {
        this.beverageRepository = beverageRepository;


    }

    public List<Beverage> findAll() {return beverageRepository.findAll();}
    @Transactional(rollbackOn = {NoSuchElementException.class})
    public Beverage findByName(String drinkName) throws NoSuchElementException{
        return beverageRepository.findById(drinkName).orElseThrow();
    }

    public List<Beverage> findByType(String type){
        return beverageRepository.findByTypeIgnoreCase(type);
    }
}












