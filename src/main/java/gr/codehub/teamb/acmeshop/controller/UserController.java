package gr.codehub.teamb.acmeshop.controller;

import gr.codehub.teamb.acmeshop.domain.User;
import gr.codehub.teamb.acmeshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/acmeshop/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.createUser(user));
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity
                .ok()
                .body(userService.getUserById(id));
    }

    @PostMapping(value = "/user/login")
    public ResponseEntity<User> userLogin(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password){
        return ResponseEntity
                .ok()
                .body(userService.userLogin(username, password));
    }
}
