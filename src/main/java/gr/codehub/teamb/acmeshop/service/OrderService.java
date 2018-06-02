package gr.codehub.teamb.acmeshop.service;

import gr.codehub.teamb.acmeshop.domain.Order;
import gr.codehub.teamb.acmeshop.domain.User;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface OrderService {
    Order confirmOrder(Long userId);
    Set<Order> getUserOrders(Long id);
}
