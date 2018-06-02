package gr.codehub.teamb.acmeshop.repository;

import gr.codehub.teamb.acmeshop.domain.Order;
import gr.codehub.teamb.acmeshop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Set<Order> findAllByUser(User user);
    List<Order> findAll();
}
