package gr.codehub.teamb.acmeshop.service;

import gr.codehub.teamb.acmeshop.domain.Order;
import gr.codehub.teamb.acmeshop.domain.Product;
import gr.codehub.teamb.acmeshop.domain.User;

import java.util.List;
import java.util.Map;

public interface ReportService {

    List<Product> mostPurchasedProducts();
    List<Product> stockProducts();
    List<Order> ordersSubmitted();
    List<User> listOfUsersWithOrders();
    Map<Product,Integer> mostPurchasedProductPerCategory();
}
