package gr.codehub.teamb.acmeshop.controller;

import gr.codehub.teamb.acmeshop.domain.Stock;
import gr.codehub.teamb.acmeshop.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/acmeshop")
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping("/stocks/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable Long id) {
        return ResponseEntity
                .ok()
                .body(stockService.getStockbyId(id));
    }

    @PostMapping("/stocks/{product_id}/quantity/{quantity}")
    public ResponseEntity<Stock> saveStock(@PathVariable Long product_id ,@PathVariable int quantity ){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(stockService.addStock(product_id,quantity));
    }

    @PutMapping("/stocks/{id}/quantity/{quantity}")
    public ResponseEntity<Stock> updateStock(@PathVariable Long id ,@PathVariable int quantity){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(stockService.updateStock(id,quantity));
    }
}
