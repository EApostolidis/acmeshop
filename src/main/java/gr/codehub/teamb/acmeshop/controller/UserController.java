package gr.codehub.teamb.acmeshop.controller;

import gr.codehub.teamb.acmeshop.domain.User;
import gr.codehub.teamb.acmeshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/acmeshop")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/users")
    public ResponseEntity<User> getUser(@RequestBody User user) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.createUser(user));
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity
                .ok()
                .body(userService.getUserById(id));
    }

    @PostMapping(value = "/users/login")
    public ResponseEntity<User> userLogin(@RequestBody User user){
        return ResponseEntity
                .ok()
                .body(userService.userLogin(user));
    }
}
