package gr.codehub.teamb.acmeshop.service;

import gr.codehub.teamb.acmeshop.domain.Order;
import gr.codehub.teamb.acmeshop.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    Order confirmOrder(Long userId);
}
