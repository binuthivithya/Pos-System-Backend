package com.ijse.cmjdfinal.backend.controller;

import com.ijse.cmjdfinal.backend.entity.Stock;
import com.ijse.cmjdfinal.backend.service.ItemService;
import com.ijse.cmjdfinal.backend.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class StockController {

    @Autowired
    private StockService stockService;

    @Autowired
    private ItemService itemService;

    @PostMapping("/stock")
    public ResponseEntity<Stock> createStock(@RequestBody Stock stock) {

        return ResponseEntity.status(201).body(stockService.createStock(stock));
    }

    @GetMapping("/stock")
    public ResponseEntity<List<Stock>> getAllStocks() {
        return ResponseEntity.status(200).body(stockService.getAllStocks());
    }

    @GetMapping("/stock/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable Long id) {
        return ResponseEntity.status(200).body(stockService.getStockById(id));
    }

    @PutMapping("/stock/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable Long id, @RequestBody Stock stock) {
        return ResponseEntity.status(200).body(stockService.updateStock(id, stock));
    }

    @DeleteMapping("/stock/{id}")
    public ResponseEntity<String> deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
        return ResponseEntity.status(200).body("Stock deleted successfully");
    }
}
