package com.UNCG_Fitness.UNCG_Fitness_Connect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping({"", "/", "/home"})
    public String home() {
        return "index";
    }

    @GetMapping("/error")
    public String showError() {
        return "error";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/403")
    public String _403() {
        return "403";
    }
}


