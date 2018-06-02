package gr.codehub.teamb.acmeshop.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Cart implements Serializable {

    private List<Product> products;
}
