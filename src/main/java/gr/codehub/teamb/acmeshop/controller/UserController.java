package gr.codehub.teamb.acmeshop.controller;

import gr.codehub.teamb.acmeshop.domain.User;
import gr.codehub.teamb.acmeshop.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acmeshop")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Retrieves the user by Id", notes = "Notes for getUserById", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @PostMapping(value = "/users")
    public ResponseEntity<User> getUser(@RequestBody User user) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.createUser(user));
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity
                .ok()
                .body(user);
    }

    @PostMapping(value = "/users/login")
    public ResponseEntity<User> userLogin(@RequestBody User user){
        return ResponseEntity
                .ok()
                .body(userService.userLogin(user));
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> userLogin(){
        return ResponseEntity
                .ok()
                .body(userService.getUsers());
    }
}
