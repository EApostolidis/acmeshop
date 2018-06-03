package gr.codehub.teamb.acmeshop.service;

import gr.codehub.teamb.acmeshop.domain.Category;
import gr.codehub.teamb.acmeshop.domain.Product;
<<<<<<< HEAD
=======
import gr.codehub.teamb.acmeshop.domain.Stock;
>>>>>>> development
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
@Transactional
public class ProductServiceImpl implements ProductService {

    static Logger log = Logger.getLogger(ProductServiceImpl.class.getName());

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

<<<<<<< HEAD
=======
    @Autowired
    private StockRepository stockRepository;

>>>>>>> development
    @Override
    public List<Product> getProductsByText(String text) {
        return productRepository.findProductsByText(text);
    }

    @Override
<<<<<<< HEAD
    public List<Product> getProductsByCategoryId(Long id) {
        return productRepository.findProductByCategoryId(id);
    }

    @Transactional
    public Product addProduct(Product product){
        //product.setCategory(categoryRepository.getCategoriesById(category_id));
        productRepository.save(product);
        return product;
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findProductById(id);
    }
=======
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
>>>>>>> development
}
