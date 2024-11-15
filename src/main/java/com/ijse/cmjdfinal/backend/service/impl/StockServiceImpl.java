package com.ijse.cmjdfinal.backend.service.impl;

import com.ijse.cmjdfinal.backend.entity.Stock;
import com.ijse.cmjdfinal.backend.repository.StockRepository;
import com.ijse.cmjdfinal.backend.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;


    @Override
    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Stock getStockById(Long id) {
        return stockRepository.findById(id).orElse(null);
    }

    @Override
    public Stock updateStock(Long id, Stock stock) {

        Stock existingStock = stockRepository.findById(id).orElse(null);

        if (existingStock == null) {
            return null;
        } else {

            existingStock.setQuantity(stock.getQuantity());
            existingStock.setItem(stock.getItem());
            existingStock.setPrice(stock.getPrice());

            return stockRepository.save(existingStock);
        }
    }

    @Override
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }
}
