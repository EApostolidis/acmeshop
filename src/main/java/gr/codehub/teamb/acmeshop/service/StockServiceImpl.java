package gr.codehub.teamb.acmeshop.service;

import gr.codehub.teamb.acmeshop.domain.Product;
import gr.codehub.teamb.acmeshop.domain.Stock;
import gr.codehub.teamb.acmeshop.repository.ProductRepository;
import gr.codehub.teamb.acmeshop.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StockServiceImpl implements StockService{

    @Autowired
    StockRepository stockRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public Stock addStock(Long productId,int quantity) {
        Product product = productRepository.findProductById(productId);
        Stock stock = new Stock();
        stock.setProduct(product);
        stock.setQuantity(quantity);
        stockRepository.save(stock);
        return stock;
    }

    @Override
    public Stock getStockbyId(Long id) {
        return stockRepository.getStockById(id);
    }

    @Override
    public Stock updateStock(Long id ,int quantity) {
        Stock stock = stockRepository.getStockByProductId(id);
        stock.setQuantity(quantity);
        stockRepository.save(stock);
        return stock;
    }
}
