package gr.codehub.teamb.acmeshop.service;

import gr.codehub.teamb.acmeshop.domain.Cart;
import gr.codehub.teamb.acmeshop.domain.Order;
import gr.codehub.teamb.acmeshop.domain.Product;
import gr.codehub.teamb.acmeshop.domain.User;
import gr.codehub.teamb.acmeshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    @Override
    @Transactional
    public Order confirmOrder(Long userId) {
        Cart cart = cartService.getCartByUser(userId);
        User user =  userService.getUserById(userId);
        Order order = new Order();
        order.setUser(user);
        Set<Product> productSet = new HashSet<>();
        productSet.addAll(cart.getProducts());
        order.setProducts(productSet);
        orderRepository.save(order);
        cartService.clearCart(userId);
        return order;
    }
}
