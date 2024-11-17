package com.ijse.cmjdfinal.backend.controller;

import com.ijse.cmjdfinal.backend.dto.OrderDetailReqDto;
import com.ijse.cmjdfinal.backend.dto.OrderItemDetailReqDto;
import com.ijse.cmjdfinal.backend.entity.Item;
import com.ijse.cmjdfinal.backend.entity.OrderedItemDetails;
import com.ijse.cmjdfinal.backend.entity.Orders;
import com.ijse.cmjdfinal.backend.entity.Stock;
import com.ijse.cmjdfinal.backend.service.ItemService;
import com.ijse.cmjdfinal.backend.service.OrderService;
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

    @PostMapping("/orders")
    public ResponseEntity<Orders> placeOrder(@RequestBody OrderDetailReqDto orderDetailReqDto) {

        Orders orders = new Orders();
        orders.setOrderDateTime(LocalDateTime.now());

        double totalPrice = 0.0;
        List<OrderedItemDetails> itemList = new ArrayList<>();
        // Loop through the ordered items in the DTO
        for(OrderItemDetailReqDto orderedItemList : orderDetailReqDto.getOrderedItems()) {
            // Update the item stock
            itemService.updateItemStock(orderedItemList.getItemId(), orderedItemList.getQuantity());

            //Calculate total price
            Item item = itemService.getItemById(orderedItemList.getItemId());
            Stock stock = item.getStock();
            double itemTotal = stock.getPrice() * orderedItemList.getQuantity();
            totalPrice += itemTotal;

            OrderedItemDetails orderedItemDetails = new OrderedItemDetails();
            orderedItemDetails.setOrder(orders);
            orderedItemDetails.setItem(item);
            orderedItemDetails.setQuantity(orderedItemList.getQuantity());
            orderedItemDetails.setUnitPrice(stock.getPrice());
            orderedItemDetails.setTotalPrice(itemTotal);

            itemList.add(orderedItemDetails);
        }

        orders.setTotalPrice(totalPrice);
        orders.setOrderedItemDetails(itemList);

        return ResponseEntity.status(201).body(orderService.createOrder(orders));
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Orders>> getAllOrders() {
        return ResponseEntity.status(200).body(orderService.getAllOrders());
    }
}
