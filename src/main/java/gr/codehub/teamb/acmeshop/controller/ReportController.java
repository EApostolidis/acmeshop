package gr.codehub.teamb.acmeshop.controller;

import gr.codehub.teamb.acmeshop.domain.Order;
import gr.codehub.teamb.acmeshop.domain.Product;
import gr.codehub.teamb.acmeshop.domain.User;
import gr.codehub.teamb.acmeshop.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/acmeshop/reports")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping(value = "/most/purchased")
    public ResponseEntity<List<Product>> getMostPurchased() {
        return ResponseEntity
                .ok()
                .body(reportService.mostPurchasedProducts());
    }

    @GetMapping(value = "/orders")
    public ResponseEntity<List<Order>> getUserOrders() {
        return ResponseEntity
                .ok()
                .body(reportService.ordersSubmitted());
    }

    @GetMapping(value = "/user/orders")
    public ResponseEntity<List<User>> listUsersWithOrders() {
        return ResponseEntity
                .ok()
                .body(reportService.listOfUsersWithOrders());
    }
}
