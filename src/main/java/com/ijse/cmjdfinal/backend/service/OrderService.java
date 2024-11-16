package com.ijse.cmjdfinal.backend.service;

import com.ijse.cmjdfinal.backend.entity.Orders;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    Orders createOrder(Orders orders);
    List<Orders> getAllOrders();
    Orders getOrderById(Long id);
    Orders updateOrder(Long id, Orders orders);
    void deleteOrder(Long id);
}
