package gr.codehub.teamb.acmeshop.domain;

import lombok.Data;

import java.util.List;

@Data
public class Cart {

    private List<Product> products;
}
