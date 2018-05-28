package gr.codehub.teamb.acmeshop.service;

import gr.codehub.teamb.acmeshop.domain.Cart;
import gr.codehub.teamb.acmeshop.domain.Product;
import gr.codehub.teamb.acmeshop.domain.User;
import gr.codehub.teamb.acmeshop.repository.CartRepository;
import gr.codehub.teamb.acmeshop.repository.ProductRepository;
import gr.codehub.teamb.acmeshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

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

    @Override
    public Cart addProduct(Long userId, Long productId) {
        Cart cart = getCartByUser(userId);
        Product product = productRepository.findProductById(productId);
        cart.getProducts().add(product);
        cartRepository.save(cart);
        return cartRepository.findCartByUser(userRepository.findUserById(userId));
    }

    @Override
    public Cart removeProduct(Long userId, Long productId) {
        Cart cart = getCartByUser(userId);
        Product product = productRepository.findProductById(productId);
        cart.getProducts().remove(product);
        return cartRepository.save(cart);
    }

    @Override
    public Cart clearCart(Long userId) {
        Cart cart = getCartByUser(userId);
        cart.getProducts().clear();
        return cartRepository.findCartByUser(userRepository.findUserById(userId));
    }
}
