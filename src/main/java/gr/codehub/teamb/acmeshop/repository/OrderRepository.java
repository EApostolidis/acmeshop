package gr.codehub.teamb.acmeshop.repository;

import gr.codehub.teamb.acmeshop.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}