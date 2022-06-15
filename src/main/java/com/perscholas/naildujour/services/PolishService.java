package com.perscholas.naildujour.services;


import com.perscholas.naildujour.data.PolishRepository;
import com.perscholas.naildujour.data.BeverageRepository;
import com.perscholas.naildujour.data.CustomerRepository;
import com.perscholas.naildujour.data.EmployeeRepository;
import com.perscholas.naildujour.models.Beverage;
import com.perscholas.naildujour.models.Polish;
import com.perscholas.naildujour.models.Customer;
import com.perscholas.naildujour.models.Employee;
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

public class PolishService {


}
