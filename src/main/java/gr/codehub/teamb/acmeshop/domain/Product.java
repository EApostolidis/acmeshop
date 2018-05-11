package gr.codehub.teamb.acmeshop.domain;

import lombok.Data;

@Data
public class Product {

    private long id;
    private String name;
    private Category category;
    private int quantiry;
}
