package gr.codehub.teamb.acmeshop.service;

import gr.codehub.teamb.acmeshop.domain.Cart;
import gr.codehub.teamb.acmeshop.domain.User;
import gr.codehub.teamb.acmeshop.repository.CartRepository;
import gr.codehub.teamb.acmeshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Cart createCart(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        return cartRepository.save(cart);
    }

    @Override
    public Cart getCartByUser(Long userId) {
        User user = userRepository.findUserById(userId);
        return cartRepository.findCartByUser(user);
    }
}
