package gr.codehub.teamb.acmeshop.service;

import gr.codehub.teamb.acmeshop.domain.Category;
import gr.codehub.teamb.acmeshop.domain.Product;
import gr.codehub.teamb.acmeshop.repository.CategoryRepository;
import gr.codehub.teamb.acmeshop.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
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
    public List<Product> getProductsByCategory(Long categoryId) {
        Category category = categoryRepository.findCategoryById(categoryId);
        return productRepository.findAllByCategory(category);
    }
}
