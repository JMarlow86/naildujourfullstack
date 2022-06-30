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
import java.util.List;

import javax.transaction.Transactional;


@Service @Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@Transactional(rollbackOn = {DataAccessException.class})


public class UserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> findUserByPhone(String phone) {
        return userRepository.findUserByPhone(phone);
    }
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public User findUserByRole(String role){
        return userRepository.findUserByRole(role);
    }
    @Transactional
    public void deleteUserByEmail(String email){
        userRepository.deleteUserByEmail(email);

    }

    public void saveOrUpdate(User u){
        userRepository.save(u);

    }
}
