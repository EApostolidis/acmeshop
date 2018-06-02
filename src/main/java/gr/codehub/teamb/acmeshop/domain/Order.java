package gr.codehub.teamb.acmeshop.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "ORDERS")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    @JsonBackReference
    private User user;


    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="ORDER_PRODUCTS", joinColumns=
    @JoinColumn(name="ORDER_ID",
            referencedColumnName="ORDER_ID"),
            inverseJoinColumns=
            @JoinColumn(name="PROD_ID",
                    referencedColumnName="PROD_ID") )
    private List<Product> products;
}
