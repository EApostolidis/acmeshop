package gr.codehub.teamb.acmeshop.service;

import gr.codehub.teamb.acmeshop.domain.Order;
import gr.codehub.teamb.acmeshop.domain.Product;
import gr.codehub.teamb.acmeshop.domain.User;
import gr.codehub.teamb.acmeshop.repository.OrderRepository;
import gr.codehub.teamb.acmeshop.repository.ProductRepository;
import gr.codehub.teamb.acmeshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Product> mostPurchasedProducts() {
        return productRepository.mostPurchsedProduct();
    }

    @Override
    public List<Product> stockProducts() {
        return null;
    }

    @Override
    public List<Order> ordersSubmitted() {
        return orderRepository.findAll();
    }

    @Override
    public List<User> listOfUsersWithOrders() {
        return userRepository.listOfUsersWithOrders();
    }

    @Override
    public Map<Product, Integer> mostPurchasedProductPerCategory() {
        return null;
    }
}
