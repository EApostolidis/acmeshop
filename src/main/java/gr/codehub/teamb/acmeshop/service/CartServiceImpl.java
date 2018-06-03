package gr.codehub.teamb.acmeshop.service;

import gr.codehub.teamb.acmeshop.domain.Cart;
import gr.codehub.teamb.acmeshop.domain.Product;
import gr.codehub.teamb.acmeshop.domain.Stock;
import gr.codehub.teamb.acmeshop.domain.User;
import gr.codehub.teamb.acmeshop.repository.CartRepository;
import gr.codehub.teamb.acmeshop.repository.ProductRepository;
import gr.codehub.teamb.acmeshop.repository.StockRepository;
import gr.codehub.teamb.acmeshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

@Service
public class CartServiceImpl implements CartService {

    static Logger log = Logger.getLogger(CartServiceImpl.class.getName());

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StockRepository stockRepository;

    @Override
    public Cart createCart(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        log.info("order " + user + "has been saved ");
        return cartRepository.save(cart);
    }

    @Override
    public Cart getCartByUser(Long userId) {
        User user = userRepository.findUserById(userId);
        return cartRepository.findCartByUser(user);
    }

    @Override
    public Cart addProduct(String token, Long productId , int quantity) {
        User user = userRepository.findUserByToken(token);
        Cart cart = getCartByUser(user.getId());
        Product product = productRepository.findProductById(productId);
        product.setQuantity(quantity);
        Stock stock = stockRepository.getStockByProductId(productId);
        Set<Product> products = new HashSet<>();
        if(product.getQuantity()<= stock.getQuantity()){
            stock.setQuantity(stock.getQuantity() - product.getQuantity());
            if(cart.getProducts().isEmpty()) {
                cart.setProducts(products);
                cart.getProducts().add(product);
                cartRepository.save(cart);
                stockRepository.save(stock);
                log.info("Stock and cart saved");
                return cart;
            }else{
                cart.getProducts().add(product);
                stockRepository.save(stock);
                cartRepository.save(cart);
                log.info("Stock and cart saved");
                return cart;
            }
        }else {
            return null;
        }
    }

    @Override
    public Cart removeProduct(String token, Long productId) {
        User user = userRepository.findUserByToken(token);
        Cart cart = getCartByUser(user.getId());
        Product product = productRepository.findProductById(productId);
        cart.getProducts().remove(product);
        log.info("Product  removed");
        return cartRepository.save(cart);
    }

    @Override
    public Cart clearCart(String token) {
        User user = userRepository.findUserByToken(token);
        Cart cart = getCartByUser(user.getId());
        cart.getProducts().clear();
        return cartRepository.findCartByUser(userRepository.findUserById(user.getId()));
    }
}
