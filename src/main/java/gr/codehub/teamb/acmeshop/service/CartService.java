package gr.codehub.teamb.acmeshop.service;

import gr.codehub.teamb.acmeshop.domain.Cart;
import gr.codehub.teamb.acmeshop.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface CartService {
    Cart createCart(User user);
    Cart getCartByUser(Long userId);
    Cart addProduct(String token, Long productId,int quantity);
    Cart removeProduct(String token, Long productId);
    Cart clearCart(String token);
}
