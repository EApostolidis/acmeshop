package gr.codehub.teamb.acmeshop.service;

import gr.codehub.teamb.acmeshop.domain.Category;
import gr.codehub.teamb.acmeshop.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProductsByText(String text);
    List<Product> getProductsByCategory(Long categoryId);
    Product createProduct(Product product,Long categoryId);
}
