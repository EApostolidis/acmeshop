package gr.codehub.teamb.acmeshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROD_ID")
    private long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    @JsonIgnore
    private Category category;
    private int quantity;

    @ManyToMany(mappedBy="products",fetch=FetchType.EAGER)
    private Set<Order> orders;
}
