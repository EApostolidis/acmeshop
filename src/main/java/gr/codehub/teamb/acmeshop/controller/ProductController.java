package gr.codehub.teamb.acmeshop.controller;

import gr.codehub.teamb.acmeshop.domain.Product;
import gr.codehub.teamb.acmeshop.service.ProductService;
import gr.codehub.teamb.acmeshop.utils.Authenticate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@RestController
@RequestMapping("/acmeshop")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private Authenticate authenticate;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProductsByText(@RequestParam(value = "text") String text) {
        return ResponseEntity
                .ok()
                .body(productService.getProductsByText(text));
    }

    @GetMapping("/products/category/{categoryId}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable Long categoryId) {
        return ResponseEntity
                .ok()
                .body(productService.getProductsByCategory(categoryId));
    }

    @PostMapping("/products/category/{categoryId}")
    public ResponseEntity<Product> addProduct(@RequestBody Product product,
                                              @PathVariable Long categoryId,
                                              @RequestParam(value = "token") String token) {
        if(authenticate.Authenticate(token) && authenticate.Authorize(token)){
            return ResponseEntity
                    .ok()
                    .body(productService.createProduct(product,categoryId));
        }else
        {
            return ResponseEntity
                    .status(UNAUTHORIZED)
                    .body(null);
        }

    }
}
