package gr.codehub.teamb.acmeshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

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

    public Cart() {
    }

    public Cart(User user, Set<Product> products) {
        this.user = user;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Product> getProducts() { return products; }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
