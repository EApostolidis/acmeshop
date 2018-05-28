package gr.codehub.teamb.acmeshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "CARTS")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    @JsonIgnore
    private User user;

    @ManyToMany
    @JoinTable(name = "CART_PRODUCTS",
        joinColumns = @JoinColumn(name = "CART_ID"),
        inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
    private Set<Product> products;
}
