package gr.codehub.teamb.acmeshop.controller;

import gr.codehub.teamb.acmeshop.domain.Product;
import gr.codehub.teamb.acmeshop.service.ProductService;
import gr.codehub.teamb.acmeshop.utils.Authenticate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

<<<<<<< HEAD
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
=======
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

>>>>>>> development
    }
}
