package gr.codehub.teamb.acmeshop.controller;

import gr.codehub.teamb.acmeshop.domain.Order;
import gr.codehub.teamb.acmeshop.service.OrderService;
import gr.codehub.teamb.acmeshop.utils.Authenticate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@RestController
@RequestMapping(value = "/acmeshop")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private Authenticate authenticate;

    @PostMapping(value = "/orders/confirm")
    public ResponseEntity<Order> confirmOrder(@RequestParam(value = "token") String token) {
        if(authenticate.Authenticate(token)) {
            return ResponseEntity
                    .ok()
                    .body(orderService.confirmOrder(token));
        }else{
            return ResponseEntity
                    .status(UNAUTHORIZED)
                    .body(null);
        }

    }

    @GetMapping(value = "/orders/user/{id}")
    public ResponseEntity<Set<Order>> getUserOrders(@PathVariable Long id) {
        return ResponseEntity
                .ok()
                .body(orderService.getUserOrders(id));
    }
}
