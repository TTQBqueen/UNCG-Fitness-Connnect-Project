package com.UNCG_Fitness.UNCG_Fitness_Connect.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Create a new User entry.
     * http://localhost:8080/users/new
     *
     * @param user the new User object.
     * @return the updated list of Users.
     */
    @PostMapping("/new")
    public List<User> addNewUser(@RequestBody User user) {
        userService.addNewUser(user);
        return userService.getAllUsers();
    }

    /**
     * Get a list of all Users in the database.
     * http://localhost:8080/users/all
     *
     * @return a list of User objects.
     */
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Get a specific User by Id.
     * http://localhost:8080/users/{userId}
     *
     * @param userId the unique Id for a User.
     * @return One User object.
     */
    @GetMapping("/{userId}")
    public User getUser(@PathVariable int userId) {
        return userService.getUserById(userId);
    }

    /**
     * Delete a User object.
     * http://localhost:8080/users/delete/{userId}
     *
     * @param userId the unique User Id.
     * @return the updated list of Users.
     */
    @DeleteMapping("/delete/{userId}")
    public List<User> deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
        return userService.getAllUsers();
    }

    /**
     * Update an existing User object.
     * http://localhost:8080/users/update/{userId}
     *
     * @param userId the unique User Id.
     * @param user   the new update User details.
     * @return the updated User object.
     */
    @PutMapping("/update/{userId}")
    public User updateUser(@PathVariable int userId, @RequestBody User user) {
        userService.updateUser(userId, user);
        return userService.getUserById(userId);
    }
}
