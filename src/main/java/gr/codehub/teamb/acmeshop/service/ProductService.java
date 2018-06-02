package gr.codehub.teamb.acmeshop.service;

import gr.codehub.teamb.acmeshop.domain.Category;
import gr.codehub.teamb.acmeshop.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProductsByText(String text);

    Product addProduct(Product product);

    List<Product> getProductsByCategoryId(Long id);

    Product findProductById(Long id);
}