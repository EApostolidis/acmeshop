package gr.codehub.teamb.acmeshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    @JsonIgnore
    private User user;


    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="OERDER_PRODUCTS", joinColumns=
    @JoinColumn(name="ORDER_ID",
            referencedColumnName="ORDER_ID"),
            inverseJoinColumns=
            @JoinColumn(name="PROD_ID",
                    referencedColumnName="PROD_ID") )
    private Set<Product> products;
}
