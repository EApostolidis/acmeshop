package gr.codehub.teamb.acmeshop.service;

import gr.codehub.teamb.acmeshop.domain.Cart;
import gr.codehub.teamb.acmeshop.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface CartService {
    Cart createCart(User user);
    Cart getCartByUser(Long userId);
    Cart addProduct(Long userId, Long productId);
    Cart removeProduct(Long userId, Long productId);
    Cart clearCart(Long userId);
}
