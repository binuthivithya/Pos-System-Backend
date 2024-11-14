package com.ijse.cmjdfinal.backend.service.impl;

import com.ijse.cmjdfinal.backend.entity.Item;
import com.ijse.cmjdfinal.backend.repository.ItemRepository;
import com.ijse.cmjdfinal.backend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item updateItem(Long id, Item item) {

        Item existingItem = itemRepository.findById(id).orElse(null);

        if (existingItem == null) {
            return null;
        } else {

            existingItem.setName(item.getName());
            existingItem.setDescription(item.getDescription());
            existingItem.setPrice(item.getPrice());
            existingItem.setCategory(item.getCategory());

            return itemRepository.save(existingItem);
        }
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
