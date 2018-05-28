package gr.codehub.teamb.acmeshop.controller;

import gr.codehub.teamb.acmeshop.domain.Cart;
import gr.codehub.teamb.acmeshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
