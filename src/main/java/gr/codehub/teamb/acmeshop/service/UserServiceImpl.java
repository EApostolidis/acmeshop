package gr.codehub.teamb.acmeshop.service;

import gr.codehub.teamb.acmeshop.domain.User;
import gr.codehub.teamb.acmeshop.repository.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final int TOKEN_SIZE = 10;

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        User newUser = user;
        newUser.setToken(null);
        userRepository.save(user);
        return userRepository.findUserById(newUser.getId());
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public User userLogin(String username, String password) {
        User user = userRepository.findUserByUsername(username);
        if (user.getPassword().equals(password)) {
            user.setToken(RandomStringUtils.randomAlphabetic(TOKEN_SIZE));
            userRepository.save(user);
            return user;
        }
        return new User();
    }


}
