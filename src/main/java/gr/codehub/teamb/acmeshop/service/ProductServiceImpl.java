package gr.codehub.teamb.acmeshop.service;

import gr.codehub.teamb.acmeshop.domain.Category;
import gr.codehub.teamb.acmeshop.domain.Product;
import gr.codehub.teamb.acmeshop.domain.Stock;
import gr.codehub.teamb.acmeshop.repository.CategoryRepository;
import gr.codehub.teamb.acmeshop.repository.ProductRepository;
import gr.codehub.teamb.acmeshop.repository.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;


@Service
public class ProductServiceImpl implements ProductService {

    static Logger log = Logger.getLogger(ProductServiceImpl.class.getName());

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<Product> getProductsByText(String text) {
        return productRepository.findProductsByText(text);
    }

    @Override
    public List<Product> getProductsByCategory(Long categoryId) {
        Category category = categoryRepository.findCategoryById(categoryId);
        return productRepository.findAllByCategory(category);
    }

    @Transactional
    public Product createProduct(Product product , Long categoryId) {
        product.setCategory(categoryRepository.findCategoryById(categoryId));
        productRepository.save(product);
        Stock stock = new Stock();
        stock.setProduct(product);
        stock.setQuantity(1);
        stockRepository.save(stock);
        log.info("product " + product + "has been saved " +" stock "+ stock + " has been saved");
        return product;
    }
}
