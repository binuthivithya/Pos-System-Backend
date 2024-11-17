package com.ijse.cmjdfinal.backend.service.impl;

import com.ijse.cmjdfinal.backend.entity.OrderedItemDetails;
import com.ijse.cmjdfinal.backend.repository.OrderedItemDetailsRepository;
import com.ijse.cmjdfinal.backend.service.OrderedItemDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderedItemDetailsServiceImpl implements OrderedItemDetailsService {

    @Autowired
    private OrderedItemDetailsRepository orderedItemDetailsRepository;

    @Override
    public OrderedItemDetails saveOrderedItemDetails(OrderedItemDetails orderedItemDetails) {
        return orderedItemDetailsRepository.save(orderedItemDetails);
    }

    @Override
    public List<OrderedItemDetails> getAllOrderedItemDetails() {
        return orderedItemDetailsRepository.findAll();
    }
}
