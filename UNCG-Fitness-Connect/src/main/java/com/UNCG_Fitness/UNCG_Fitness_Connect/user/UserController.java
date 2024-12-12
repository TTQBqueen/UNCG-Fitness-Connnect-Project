package com.UNCG_Fitness.UNCG_Fitness_Connect.user;

import com.UNCG_Fitness.UNCG_Fitness_Connect.fitnessClass.Class;
import com.UNCG_Fitness.UNCG_Fitness_Connect.fitnessClass.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Create a new User entry.
     * http://localhost:8080/users/new
     *
     * @param user the new User object.
     * @param model the Model object to pass data to the view.
     * @return the updated list of Users.
     */
    @PostMapping("/users/new")
    public String addNewUser(@ModelAttribute User user, Model model) {
        userService.addNewUser(user);
        model.addAttribute("users", userService.getAllUsers());
        return "redirect:/classes/all";
    }
    @GetMapping("/users/createForm")
    public String showCreateForm(){
        return "signup";
    }

    /**
     * Get a list of all Users in the database.
     * http://localhost:8080/users/all
     *
     * @return a list of User objects.
     */
    @GetMapping("admin/users/all")
    public String getAllUsers(Model model) {
        model.addAttribute("userList", userService.getAllUsers());
        model.addAttribute("title", "All Users");
        return "/User/user-list";
    }


    /**
     * Get a specific User by Id.
     * http://localhost:8080/users/{userId}
     *
     * @param userId the unique Id for a User.
     * @param model the Model object to pass data to the view.
     * @return the view displaying the user's details.
     */
    @GetMapping("/admin/users/{userId}")
    public String getUser(@PathVariable int userId, Model model) {
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "/User/user-details";
    }

    /**
     * Delete a User object.
     * http://localhost:8080/users/delete/{userId}
     *
     * @param userId the unique User Id.
     * @param model the Model object to pass data to the view.
     * @return the updated list of Users.
     */
    @DeleteMapping("/users/delete/{userId}")
    public String confirmDelete(@PathVariable int userId, Model model) {
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "/User/user-delete";
    }

    /**
     * Perform the deletion.
     *
     * @param userId the unique User Id.
     * @param model the Model object to pass data to the view.
     * @return the updated list of Users.
     */
    @PostMapping("/users/delete/{userId}")
    public String deleteUser(@PathVariable int userId, Model model) {
        userService.deleteUser(userId);
        model.addAttribute("users", userService.getAllUsers());
        return "redirect:/users/all";
    }

    /**
     * Update an existing User object.
     * http://localhost:8080/users/update/{userId}
     *
     * @param userId the unique User Id.
     * @param user the new updated User details.
     * @param model the Model object to pass data to the view.
     * @return the view displaying the updated user's details.
     */
    @PostMapping("admin/update/{userId}")
    public String updateUser(@PathVariable int userId, @ModelAttribute User user, Model model) {
        userService.updateUser(userId, user);
        model.addAttribute("user", userService.getUserById(userId));
        return "/User/user-details";
    }

    // view profile to update
    @GetMapping("/profile")
    public String showUpdateProfile(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentUser = userService.getUserByUserName(username);

        model.addAttribute("user", currentUser);

        return "fragments/profile";
    }
    @PostMapping("/profile/update")
    public String updateProfile(User user) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentUser = userService.getUserByUserName(name);

        user.setUserName(currentUser.getUserName());

        userService.saveUser(user);

        return "redirect:/profile";
    }

}