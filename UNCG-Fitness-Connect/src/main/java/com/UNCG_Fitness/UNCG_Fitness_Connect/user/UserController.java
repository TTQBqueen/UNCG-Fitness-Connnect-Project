package com.UNCG_Fitness.UNCG_Fitness_Connect.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/new")
    public String createUser(User user) {
        service.saveUser(user);
        return "redirect:/users/all";
    }

    @GetMapping("/all")
    public String getAllUsers(Model model,
                              @RequestParam(name = "continue",required = false) String cont) {
        model.addAttribute("userList", service.getAllUsers());
        model.addAttribute("title", "User List");
        return "user/user-list";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable long id, Model model) {
        model.addAttribute("user", service.getUserById(id));
        model.addAttribute("title", "User Details:"+id);
        return "user/user-detail";
    }
}
