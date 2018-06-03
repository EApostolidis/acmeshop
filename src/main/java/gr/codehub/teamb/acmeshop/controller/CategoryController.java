package gr.codehub.teamb.acmeshop.controller;

import gr.codehub.teamb.acmeshop.domain.Category;
import gr.codehub.teamb.acmeshop.domain.Product;
import gr.codehub.teamb.acmeshop.service.CategoryService;
import gr.codehub.teamb.acmeshop.utils.Authenticate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@RestController
@RequestMapping("/acmeshop")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private Authenticate authenticate;

    @GetMapping(value = "/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity
                .ok()
                .body(categoryService.getAllCategories());
    }

    @GetMapping(value = "/categories/{id}")
    public ResponseEntity<Category> getCatehoryById(@PathVariable Long id) {
        return ResponseEntity
                .ok()
                .body(categoryService.getCategoryById(id));
    }

    @PostMapping("/categories")
    public ResponseEntity<Category> addCategory(@RequestBody Category category,
                                               @RequestParam(value = "token") String token) {
        if(authenticate.Authenticate(token) && authenticate.Authorize(token)){
            return ResponseEntity
                    .ok()
                    .body(categoryService.addCategory(category));
        }else
        {
            return ResponseEntity
                    .status(UNAUTHORIZED)
                    .body(null);
        }
    }


}
