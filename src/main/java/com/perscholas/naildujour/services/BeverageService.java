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


@Service @Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@Transactional(rollbackOn = {DataAccessException.class})
public class BeverageService {
    BeverageRepository beverageRepository;

    @Autowired
    public BeverageService(BeverageRepository beverageRepository) {
        this.beverageRepository = beverageRepository;
    }

    public List<Beverage> findAll() {
        return beverageRepository.findAll();
    }

    public Beverage findBeverageByName(String name) {
        return beverageRepository.findBeverageByName(name);
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












