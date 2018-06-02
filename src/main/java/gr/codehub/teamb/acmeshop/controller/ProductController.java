package gr.codehub.teamb.acmeshop.controller;

import gr.codehub.teamb.acmeshop.domain.Product;
import gr.codehub.teamb.acmeshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/product/{id}")
    public ResponseEntity<List<Product>> getProductsByText(@PathVariable Long id) {
        return ResponseEntity
                .ok()
                .body(productService.getProductsByCategoryId(id));
    }

    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productService.addProduct(product));
    }
}
