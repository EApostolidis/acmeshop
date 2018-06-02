package gr.codehub.teamb.acmeshop.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "PRODUCTS")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROD_ID")
    private long id;

    private String name;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @OneToOne(mappedBy = "product",fetch=FetchType.LAZY)
    @JsonIgnore
    private Stock stock;

    @ManyToMany(mappedBy="products",fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Order> orders;
}
