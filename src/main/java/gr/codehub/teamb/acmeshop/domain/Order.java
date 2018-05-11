package gr.codehub.teamb.acmeshop.domain;

import lombok.Data;

@Data
public class Order {

    private long id;
    private User user;
    private Cart cart;
}
