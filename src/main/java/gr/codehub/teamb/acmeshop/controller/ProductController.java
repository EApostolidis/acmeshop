package gr.codehub.teamb.acmeshop.controller;

import gr.codehub.teamb.acmeshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acmeshop/api")
public class ProductController {

    @Autowired
    private ProductService productService;

}
