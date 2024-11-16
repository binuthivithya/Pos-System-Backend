package com.ijse.cmjdfinal.backend.service.impl;

import com.ijse.cmjdfinal.backend.entity.Orders;
import com.ijse.cmjdfinal.backend.repository.OrderRepository;
import com.ijse.cmjdfinal.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Orders createOrder(Orders orders) {
        return orderRepository.save(orders);
    }

    @Override
    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Orders getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Orders updateOrder(Long id, Orders orders) {

        Orders existingOrders = orderRepository.findById(id).orElse(null);

        if (existingOrders == null) {
            return null;
        } else {
            existingOrders.setOrderDateTime(orders.getOrderDateTime());
            existingOrders.setTotalPrice(orders.getTotalPrice());
            existingOrders.setOrderedItems(orders.getOrderedItems());
            return orderRepository.save(existingOrders);
        }
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
