package com.perscholas.naildujour.services;


import com.perscholas.naildujour.data.OrderRepository;
import com.perscholas.naildujour.models.Order;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import javax.transaction.Transactional;


@Service @Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@Transactional(rollbackOn = {DataAccessException.class})

public class OrderService {
    OrderRepository orderRepository;


    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order findOrderByOrderId(int orderId) {
        return orderRepository.findOrderByOrderId(orderId);
    }

    @Transactional
    public void deleteOrderByOrderId(int orderId) {
        orderRepository.deleteOrderByOrderId(orderId);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }


    public void saveOrUpdate(Order o) {
        orderRepository.save(o);

    }




}
