package com.ijse.cmjdfinal.backend.service;

import com.ijse.cmjdfinal.backend.entity.Stock;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StockService {
    Stock createStock(Stock stock);
    List<Stock> getAllStocks();
    Stock getStockById(Long id);
    Stock updateStock(Long id, Stock stock);
    void deleteStock(Long id);
}
