package gr.codehub.teamb.acmeshop.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import gr.codehub.teamb.acmeshop.enums.Role;
import lombok.Data;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "USERS")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private long id;

    private String username;
    //TODO: hash password
    private String password;
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String token;

    @OneToMany(mappedBy = "user",fetch=FetchType.LAZY)
    @JsonManagedReference
    private List<Order> orders;
}
