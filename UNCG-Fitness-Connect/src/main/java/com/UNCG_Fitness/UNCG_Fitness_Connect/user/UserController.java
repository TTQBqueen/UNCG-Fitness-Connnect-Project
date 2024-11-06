package com.UNCG_Fitness.UNCG_Fitness_Connect.user;


import com.UNCG_Fitness.UNCG_Fitness_Connect.fitnessClass.Class;
import com.UNCG_Fitness.UNCG_Fitness_Connect.fitnessClass.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    ClassService classService;

//    // create user
//    @PostMapping("/new")
//    public String createUser(@ModelAttribute("user") User user) {
//        service.saveUser(user);
//        return "redirect:/users/all";
//    }
//
//    @GetMapping("/all")
//    public String getAllUsers(Model model,
//                              @RequestParam(name = "continue",required = false) String cont) {
//        model.addAttribute("userList", service.getAllUsers());
//        model.addAttribute("title", "User List");
//        return "user/user-list";
//    }
//
//    @GetMapping("/{id}")
//    public String getUser(@PathVariable long id, Model model) {
//        model.addAttribute("user", service.getUserById(id));
//        model.addAttribute("title", "User Details:"+id);
//        return "user/user-details";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteUser(@PathVariable long id, Model model) {
//        service.deleteUser(id);
//        return "redirect:/users/all";
//    }
//
//    @GetMapping("/update/{id}")
//    public String updateUserForm(@PathVariable long id, Model model) {
//        model.addAttribute("user", service.getUser(id));
//        return "user/user-update";
//    }
//
//    @PostMapping("/update")
//    public String updateUser(User user) {
//        service.updateUser(user);
//        return "redirect:/users/"+user.getUserId();
//    }


//    New user
    //    SubscriptionService subsService;





//    All User
    /**
     * Get a list of all users .
     * http://localhost:8080/users/all
     *
     * @return a list of User objects.
     */
    @GetMapping("/all")
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }
//    userId
    /**
     * Get a specific user by userId.
     * http://localhost:8080/users/2
     *
     * @param userId the unique userId for a Users.
     * @return One User object.
     */
    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable int userId) {
        return userService.getUserById(userId);
    }

//    Role
    /**
     * Get a list of Users based on their role.
     * http://localhost:8080/Users/role
     *
     * @param role the search key.
     * @return A list of Users objects matching the role key.
     */

    @GetMapping("/role")
    public List<User> getUsersByRole(@RequestParam(name = "role", defaultValue = "Customer") String role) {
        return userService.getUsersByRole(role);
    }

//Get by userName
    /**
     * Get a list of Users based on their userName.
     * http://localhost:8080/users?userName=yourmama@uncg.edu
     *
     * @param userName the search key.
     * @return A list of User objects matching the search key.
     */
    @GetMapping("")
    public List<User> getUsersByName(@RequestParam(name = "userName", defaultValue = "userName@uncg.edu") String userName) {
        return userService.getUsersByUserName(userName);
    }

//    New user
    /**
     * Create a new User entry.
     * http://localhost:8080/users/new --data '{ "ClassId": 4, "name": "sample4", "major": "csc", "gpa": 3.55}'
     *
     * @param user the new User object.
     * @return the updated list of Users.
     */
    @PostMapping("/new")
    public List<User> addNewUser(@RequestBody User user) {
        userService.addNewUser(user);
        return userService.getAllUsers();
    }
//Update User
    /**
     * Update an existing User object.
     * http://localhost:8080/users/update/2 --data '{
     * "classId": 1, "title": "cat", "ScientificName": "Felion", "Classification": "manmmal", "Habitat": "outside" , "Description": "this is a cat" }'
     *
     * @param userId the unique Class Id.
     * @param user the new update user details.
     * @return the updated Class object.
     */
    @PutMapping("/update/{userId}")
    public User updateUser(@PathVariable int userId, @RequestBody User user) {
        userService.updateUser(userId, user);
        return userService.getUserById(userId);
    }
//Delete
    /**
     * Delete a User object.
     * http://localhost:8080/users/delete/2
     *
     * @param userId the unique User Id.
     * @return the updated list of Users.
     */
    @DeleteMapping("/delete/{userId}")
    public List<User> deleteUserById(@PathVariable int userId) {
        userService.deleteUserById(userId);
        return userService.getAllUsers();
    }

}



