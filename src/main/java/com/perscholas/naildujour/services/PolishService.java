package com.perscholas.naildujour.services;


import com.perscholas.naildujour.data.PolishRepository;
import com.perscholas.naildujour.models.Polish;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;
import java.util.List;


@Service @Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@Transactional(rollbackOn = {DataAccessException.class})
public class PolishService {

    PolishRepository polishRepository;

    @Autowired
    public PolishService(PolishRepository polishRepository) {
        this.polishRepository = polishRepository;
    }

    public List<Polish> findAll() {
        return polishRepository.findAll();
    }

    public Polish findPolishByName(String polishName){
        return polishRepository.findPolishByPolishName(polishName);
    }

    public List<Polish> findPolishById(int polishId){
        return polishRepository.findPolishByPolishId(polishId);

    }
    @Transactional
    public void deletePolishByName(String polishName){
        polishRepository.deletePolishByPolishName(polishName);
    }
    public void saveOrUpdate(Polish p) {
        polishRepository.save(p);
    }

}
