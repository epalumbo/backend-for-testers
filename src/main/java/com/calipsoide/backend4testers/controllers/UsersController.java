package com.calipsoide.backend4testers.controllers;

import com.calipsoide.backend4testers.dto.UserDTO;
import com.calipsoide.backend4testers.exceptions.AlreadyRegisteredException;
import com.calipsoide.backend4testers.exceptions.UsernameNotFoundException;
import com.calipsoide.backend4testers.logging.Logging;
import com.calipsoide.backend4testers.model.User;
import com.calipsoide.backend4testers.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import static java.util.Optional.ofNullable;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import static org.springframework.util.MimeTypeUtils.TEXT_PLAIN_VALUE;

@Api(produces = APPLICATION_JSON_VALUE, protocols = "http")
@RequestMapping(value = "/api/v1/users", produces = APPLICATION_JSON_VALUE)
@RestController
public class UsersController implements Logging {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Retrieve all registered users", response = Iterable.class)
    @GetMapping("/all")
    public Iterable<User> allUsers() {
        log().info("Retrieving all users...");
        return userService.getAllUsers();
    }

    @ApiOperation(value = "Log in users", response = User.class)
    @GetMapping("/access")
    public User logIn(Authentication authentication) {
        log().info("Attempting login of user [{}]...", authentication.getName());
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userService.getUser(userDetails.getUsername());
    }

    @ApiOperation(value = "View details about a user", response = User.class)
    @GetMapping("/details")
    public User getDetails(@RequestParam String username) {
        log().info("Retrieving details for user [{}]...", username);
        return ofNullable(userService.getUser(username)).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    @ApiOperation(value = "Sign-Up a new user", response = User.class)
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody UserDTO user) {
        log().info("Registering new user [{}]...", user);
        if (userService.exists(user.getUsername(), user.getEmail())) {
            throw new AlreadyRegisteredException();
        }
        User saveUser = user.toUser();
        userService.saveUser(saveUser);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update a user", response = User.class)
    @PutMapping
    public User updateUser(@RequestBody UserDTO user) {
        User saveUser = user.toUser();
        log().info("Updating user [{}]...", saveUser);
        return userService.updateUser(saveUser);
    }

    @ApiOperation(value = "Delete a user", response = String.class)
    @DeleteMapping(produces = TEXT_PLAIN_VALUE)
    public String deleteUser(@RequestBody UserDTO user) {
        log().info("Attempting to delete user [{}]...", user);
        User removeUser = user.toUser();
        userService.deleteUser(removeUser);
        return "User '" + user.getUsername() + "' removed from database.";
    }

}