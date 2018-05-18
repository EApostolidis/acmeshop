package gr.codehub.teamb.acmeshop.service;

import gr.codehub.teamb.acmeshop.domain.Product;
import gr.codehub.teamb.acmeshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProductsByText(String text) {
        return productRepository.findProductsByText(text);
    }
}
