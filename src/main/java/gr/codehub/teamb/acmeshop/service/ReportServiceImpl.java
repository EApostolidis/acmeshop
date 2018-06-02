package gr.codehub.teamb.acmeshop.service;

import gr.codehub.teamb.acmeshop.domain.Order;
import gr.codehub.teamb.acmeshop.domain.Product;
import gr.codehub.teamb.acmeshop.domain.User;
import gr.codehub.teamb.acmeshop.repository.OrderRepository;
import gr.codehub.teamb.acmeshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Map;

public class ReportServiceImpl implements ReportService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> mostPurchasedProducts() {
        return null;
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
        return null;
    }

    @Override
    public Map<Product, Integer> mostPurchasedProductPerCategory() {
        return null;
    }
}
