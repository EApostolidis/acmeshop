package gr.codehub.teamb.acmeshop.service;

import gr.codehub.teamb.acmeshop.domain.Category;
import gr.codehub.teamb.acmeshop.domain.Product;
import gr.codehub.teamb.acmeshop.repository.CategoryRepository;
import gr.codehub.teamb.acmeshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Product> getProductsByText(String text) {
        return productRepository.findProductsByText(text);
    }

    @Override
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
}
