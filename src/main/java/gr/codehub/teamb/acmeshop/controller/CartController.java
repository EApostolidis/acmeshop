package gr.codehub.teamb.acmeshop.controller;

import gr.codehub.teamb.acmeshop.domain.Cart;
import gr.codehub.teamb.acmeshop.service.CartService;
import gr.codehub.teamb.acmeshop.utils.Authenticate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@RestController
@RequestMapping(value = "/acmeshop")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private Authenticate authenticate;

    @GetMapping(value = "/carts/user/{id}")
    public ResponseEntity<Cart> getCartByUser(@PathVariable Long id) {
        return ResponseEntity
                .ok()
                .body(cartService.getCartByUser(id));
    }

    @PostMapping(value = "/carts/product/{productId}/quantity/{quantity}")
    public ResponseEntity<Cart> addProduct(@PathVariable Long productId,
                                           @PathVariable Integer quantity,
                                           @RequestParam(value = "token") String token){
        if(authenticate.Authenticate(token)) {
            return ResponseEntity
                    .ok()
                    .body(cartService.addProduct(token, productId, quantity));
        }else{
            return ResponseEntity
                    .status(UNAUTHORIZED)
                    .body(null);
        }
    }

    @DeleteMapping(value = "/carts/product/{productId}")
    public ResponseEntity<Cart> removeProduct(@PathVariable Long productId,
                                              @RequestParam(value = "token") String token){
        if(authenticate.Authenticate(token)) {
            return ResponseEntity
                    .ok()
                    .body(cartService.removeProduct(token, productId));
        }else{
            return ResponseEntity
                    .status(UNAUTHORIZED)
                    .body(null);
        }
    }

    @DeleteMapping(value = "/carts/clear")
    public ResponseEntity<Cart> clearCart(@RequestParam(value = "token") String token) {
        if(authenticate.Authenticate(token)) {
            return ResponseEntity
                    .ok()
                    .body(cartService.clearCart(token));
        }else{
            return ResponseEntity
                    .status(UNAUTHORIZED)
                    .body(null);
        }
    }
}
