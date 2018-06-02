package gr.codehub.teamb.acmeshop.controller;

import gr.codehub.teamb.acmeshop.domain.Cart;
import gr.codehub.teamb.acmeshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/acmeshop")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping(value = "/carts/user/{id}")
    public ResponseEntity<Cart> getCartByUser(@PathVariable Long id) {
        return ResponseEntity
                .ok()
                .body(cartService.getCartByUser(id));
    }

    @PostMapping(value = "/carts/user/{userId}/product/{productId}/quantity/{quantity}")
    public ResponseEntity<Cart> addProduct(@PathVariable Long userId, @PathVariable Long productId,@PathVariable Integer quantity) {
        return ResponseEntity
                .ok()
                .body(cartService.addProduct(userId, productId,quantity));
    }

    @DeleteMapping(value = "/carts/user/{userId}/product/{productId}")
    public ResponseEntity<Cart> removeProduct(@PathVariable Long userId, @PathVariable Long productId) {
        return ResponseEntity
                .ok()
                .body(cartService.removeProduct(userId, productId));
    }

    @DeleteMapping(value = "/carts/user/{userId}/clear")
    public ResponseEntity<Cart> clearCart(@PathVariable Long userId) {
        return ResponseEntity
                .ok()
                .body(cartService.clearCart(userId));
    }
}
