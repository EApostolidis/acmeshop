package gr.codehub.teamb.acmeshop.controller;

import gr.codehub.teamb.acmeshop.domain.Product;
import gr.codehub.teamb.acmeshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/acmeshop/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getProductsByText(@RequestParam(value = "text") String text) {
        return ResponseEntity
                .ok()
                .body(productService.getProductsByText(text));
    }
}
