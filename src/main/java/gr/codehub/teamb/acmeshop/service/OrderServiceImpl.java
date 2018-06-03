package gr.codehub.teamb.acmeshop.service;

import gr.codehub.teamb.acmeshop.domain.Cart;
import gr.codehub.teamb.acmeshop.domain.Order;
import gr.codehub.teamb.acmeshop.domain.Product;
import gr.codehub.teamb.acmeshop.domain.User;
import gr.codehub.teamb.acmeshop.repository.OrderRepository;
import gr.codehub.teamb.acmeshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    static Logger log = Logger.getLogger(OrderServiceImpl.class.getName());

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    @Override
    @Transactional
    public Order confirmOrder(String token) {
        User user =  userRepository.findUserByToken(token);
        Cart cart = cartService.getCartByUser(user.getId());
        Order order = new Order();
        order.setUser(user);
        Set<Product> productSet = new HashSet<>();
        productSet.addAll(cart.getProducts());
        order.setProducts(productSet);
        orderRepository.save(order);
        cartService.clearCart(token);
        log.info("order " + order + "has been saved ");
        return order;
    }

    @Override
    public Set<Order> getUserOrders(Long id) {
        User user = userService.getUserById(id);
        return orderRepository.findAllByUser(user);
    }
}
