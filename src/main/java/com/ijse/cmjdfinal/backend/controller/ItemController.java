package com.ijse.cmjdfinal.backend.controller;

import com.ijse.cmjdfinal.backend.entity.Item;
import com.ijse.cmjdfinal.backend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/item")
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        return ResponseEntity.status(201).body(itemService.createItem(item));
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        return ResponseEntity.status(200).body(itemService.getItemById(id));
    }

    @GetMapping("/item")
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.status(200).body(itemService.getAllItems());
    }

    @PutMapping("/item/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item item) {
        return ResponseEntity.status(200).body(itemService.updateItem(id, item));
    }

    @DeleteMapping("/item/{id}")
    public ResponseEntity<>
}
