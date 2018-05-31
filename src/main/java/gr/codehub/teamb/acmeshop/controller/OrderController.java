package gr.codehub.teamb.acmeshop.controller;

import gr.codehub.teamb.acmeshop.domain.Order;
import gr.codehub.teamb.acmeshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/acmeshop")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/orders/user/{id}")
    public ResponseEntity<Order> confirmOrder(@PathVariable Long id) {
        return ResponseEntity
                .ok()
                .body(orderService.confirmOrder(id));
    }
}
