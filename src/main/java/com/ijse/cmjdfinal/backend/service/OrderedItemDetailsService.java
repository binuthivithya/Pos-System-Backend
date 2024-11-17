package com.ijse.cmjdfinal.backend.service;

import com.ijse.cmjdfinal.backend.entity.OrderedItemDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderedItemDetailsService {
    OrderedItemDetails saveOrderedItemDetails(OrderedItemDetails orderedItemDetails);
    List<OrderedItemDetails> getAllOrderedItemDetails();
}