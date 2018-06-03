package gr.codehub.teamb.acmeshop.service;

import gr.codehub.teamb.acmeshop.domain.Stock;

public interface StockService {
    Stock addStock(Long productId,int quantity);

    Stock getStockbyId(Long id);

    Stock updateStock(Long id,int quantity);
}
