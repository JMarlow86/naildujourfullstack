package com.perscholas.naildujour.data;

import com.perscholas.naildujour.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;



public interface OrderRepository extends JpaRepository<Order, Integer> {



    Order findOrderByOrderId (int orderId);

    List<Order> findAll ();

    void deleteOrderByOrderId(int orderId);
}
