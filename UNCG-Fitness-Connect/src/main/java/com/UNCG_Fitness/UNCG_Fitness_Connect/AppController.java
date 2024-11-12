package com.UNCG_Fitness.UNCG_Fitness_Connect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping({"", "/", "/home"})
    public String home() {
        return "redirect:/users/all";
    }

}
