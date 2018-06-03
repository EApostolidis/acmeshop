package gr.codehub.teamb.acmeshop.service;

import gr.codehub.teamb.acmeshop.domain.Cart;
import gr.codehub.teamb.acmeshop.domain.User;
import gr.codehub.teamb.acmeshop.repository.CartRepository;
import gr.codehub.teamb.acmeshop.repository.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService {

    static Logger log = Logger.getLogger(UserServiceImpl.class.getName());

    private static final int TOKEN_SIZE = 10;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartService cartService;

    @Transactional
    public User createUser(User user) {
        user.setCart(cartService.createCart(user));
        //user.setToken(RandomStringUtils.randomAlphabetic(TOKEN_SIZE));
        user.setToken(null);
        userRepository.save(user);
        log.info("user" + user  + "has been saved");
        return userRepository.findUserById(user.getId());
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public User userLogin(User user) {
        User tmpUser = userRepository.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (tmpUser != null) {
            tmpUser.setToken(RandomStringUtils.randomAlphabetic(TOKEN_SIZE));
            userRepository.save(tmpUser);
            return userRepository.findUserById(tmpUser.getId());
        }
        return user;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
