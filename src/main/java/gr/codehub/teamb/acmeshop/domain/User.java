package gr.codehub.teamb.acmeshop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gr.codehub.teamb.acmeshop.enums.Role;
import lombok.Data;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;

@Data
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String password;
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonIgnore
    private Cart cart;
}
