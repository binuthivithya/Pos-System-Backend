package com.ijse.cmjdfinal.backend.controller;

import com.ijse.cmjdfinal.backend.dto.OrderDetailReqDto;
import com.ijse.cmjdfinal.backend.dto.OrderItemDetailReqDto;
import com.ijse.cmjdfinal.backend.entity.Item;
import com.ijse.cmjdfinal.backend.entity.Orders;
import com.ijse.cmjdfinal.backend.entity.Stock;
import com.ijse.cmjdfinal.backend.service.ItemService;
import com.ijse.cmjdfinal.backend.service.OrderService;
import com.ijse.cmjdfinal.backend.service.StockService;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private StockService stockService;

    @PostMapping("/orders")
    public ResponseEntity<Orders> placeOrder(@RequestBody OrderDetailReqDto orderDetailReqDto) {

        Orders orders = new Orders();
        orders.setOrderDateTime(LocalDateTime.now());

        double totalPrice = 0.0;
        List<Item> itemList = new ArrayList<>();

        for(OrderItemDetailReqDto orderedItemList : orderDetailReqDto.getOrderedItems()) {
            itemService.updateItemStock(orderedItemList.getItemId(), orderedItemList.getQuantity());
            totalPrice += ((itemService.getItemById(orderedItemList.getItemId()).getStock().getPrice())*(orderedItemList.getQuantity()));
            itemList.add(itemService.getItemById(orderedItemList.getItemId()));
        }

        orders.setTotalPrice(totalPrice);
        orders.setOrderedItems(itemList);

        return ResponseEntity.status(201).body(orderService.createOrder(orders));
    }
}
