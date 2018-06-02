package gr.codehub.teamb.acmeshop.repository;

import gr.codehub.teamb.acmeshop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(Long id);
    User findUserByUsernameAndPassword(String username, String password);
    User findUserByToken(String token);

    @Query(value = "select * from users where id in (select user_id from orders group by user_id order by count(*) desc)", nativeQuery = true)
    List<User> listOfUsersWithOrders();
}
