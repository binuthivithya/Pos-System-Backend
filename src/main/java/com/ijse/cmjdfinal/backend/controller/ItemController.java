package com.ijse.cmjdfinal.backend.controller;

import com.ijse.cmjdfinal.backend.dto.ItemReqDto;
import com.ijse.cmjdfinal.backend.dto.StockReqDto;
import com.ijse.cmjdfinal.backend.entity.Category;
import com.ijse.cmjdfinal.backend.entity.Item;
import com.ijse.cmjdfinal.backend.entity.Stock;
import com.ijse.cmjdfinal.backend.service.CategoryService;
import com.ijse.cmjdfinal.backend.service.ItemService;
import com.ijse.cmjdfinal.backend.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private StockService stockService;

    @PostMapping("/item")
    public ResponseEntity<Item> createItem(@RequestBody ItemReqDto itemReqDto) {

        Item item = new Item();
        item.setName(itemReqDto.getName());
        item.setDescription(itemReqDto.getDescription());

        Category category = categoryService.getCategoryById(itemReqDto.getCategoryId());
        item.setCategory(category);

        Stock stock = stockService.getStockById(itemReqDto.getStockId());
        item.setStock(stock);

        return ResponseEntity.status(200).body(itemService.createItem(item));
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
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody ItemReqDto itemReqDto) {

        Item item = new Item();
        item.setName(itemReqDto.getName());
        item.setDescription(itemReqDto.getDescription());

        Category category = categoryService.getCategoryById(itemReqDto.getCategoryId());
        item.setCategory(category);

        Stock stock = stockService.getStockById(itemReqDto.getStockId());
        item.setStock(stock);

        return ResponseEntity.status(200).body(itemService.updateItem(id, item));
    }

    @DeleteMapping("/item/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.status(200).body("Item deleted successfully");
    }

    @PutMapping("/item/{id}/stock")
    public ResponseEntity<Item> updateItemStock(@PathVariable Long id, @RequestBody StockReqDto stockReqDto) {
        return ResponseEntity.status(200).body(itemService.updateItemStock(id, stockReqDto.getQuantity()));
    }
}
