package gr.codehub.teamb.acmeshop.domain;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "STOCKS")
public class Stock implements Serializable {
=======
import javax.persistence.*;

@Entity
@Table(name = "STOCKS")
public class Stock {


>>>>>>> development

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STOCK_ID")
    private long id;

    @OneToOne
    @JoinColumn(name="PROD_ID")
    private Product product;

    private int quantity;
<<<<<<< HEAD
=======

    public Stock(){}

    public Stock(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


>>>>>>> development
}
