package com.perscholas.naildujour.services;


import com.perscholas.naildujour.data.BeverageRepository;
import com.perscholas.naildujour.models.Beverage;


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
    BeverageRepository beverageRepository;

    @Autowired
    public BeverageService(BeverageRepository beverageRepository) {
        this.beverageRepository = beverageRepository;


    }
//    Beverage findBeverageByName(String name);
//    Beverage findBeverageByType(String type);
//    List<Beverage> findAll();
//    void deleteBeverageByName(String name);

    public List<Beverage> findAll() {
        return beverageRepository.findAll();
    }

    public Beverage findBeverageByName(String drinkName) {

        return beverageRepository.findBeverageByName(drinkName);
    }

    public List<Beverage> findBeveragesByType(String type) {
        return beverageRepository.findBeverageByType(type);
    }


    @Transactional
    public void deleteBeverageByName(String name){

        beverageRepository.deleteBeverageByName(name);
    }

    public void saveOrUpdate(Beverage b){
     beverageRepository.save(b);

    }

}












