package gr.codehub.teamb.acmeshop.service;

import gr.codehub.teamb.acmeshop.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
    User userLogin(User user);
    List<User> getUsers();
}
