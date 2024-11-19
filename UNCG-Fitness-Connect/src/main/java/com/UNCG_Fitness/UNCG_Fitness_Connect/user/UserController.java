package com.UNCG_Fitness.UNCG_Fitness_Connect.user;

import com.UNCG_Fitness.UNCG_Fitness_Connect.subscription.Subscription;
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

    /**
     * Create a new User entry.
     * http://localhost:8080/users/new
     *
     * @return the updated list of Users.
     */
    @GetMapping("/createForm")
    public String showSignupForm() { return "signup.html"; }
    @PostMapping("/new")
    public String addNewUser(User user) {
        userService.addNewUser(user);
        return "redirect:/users/all";
    }

    /**
     * Get a list of all Users in the database.
     * http://localhost:8080/users/all
     *
     * @return a list of User objects.
     */
    @GetMapping("/all")
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
    @GetMapping("/{userId}")
    public String getUser(@PathVariable int userId, Model model) {
        User user = userService.getUserById(userId);
        if (user == null) {
            return "error/404"; // Redirect to a 404 error page
        }
        model.addAttribute("user", user);
        return "User/user-details";
    }

    /**
     * Show confirmation for deleting a user.
     * http://localhost:8080/users/delete/{userId}
     *
     * @param userId the unique User Id.
     * @param model the Model object to pass data to the view.
     *
     */
    @GetMapping("/delete/{userId}")
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
    @PostMapping("/delete/{userId}")
    public String deleteUser(@PathVariable int userId, Model model) {
        userService.deleteUser(userId);
        model.addAttribute("users", userService.getAllUsers());
        return "redirect:/users/all";
    }

    /**
     * Show the update form.
     * http://localhost:8080/users/update/{userId}
     *
     * @param userId the unique User Id.
     * @param model the Model object to pass data to the view.
     */
    @GetMapping("/update/{userId}")
    public String updateUser(@PathVariable int userId, Model model) {
        model.addAttribute("user", userService.getUserById(userId));
        return "/User/user-update";
    }

    /**
     * Perform the update.
     *
     * @param user the new updated User details.
     * @return the view displaying the updated user's details.
     */
    @PostMapping("/update")
    public String updateUser(User user) {
        userService.saveUser(user);
        return "redirect:/users/" + user.getId();
    }
}
