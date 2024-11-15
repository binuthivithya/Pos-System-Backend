package com.ijse.cmjdfinal.backend.service;

import com.ijse.cmjdfinal.backend.entity.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    Item createItem(Item item);
    Item getItemById(Long id);
    List<Item> getAllItems();
    Item updateItem(Long id, Item item);
    void deleteItem(Long id);
    Item updateItemStock(Long id, int qty);
}
