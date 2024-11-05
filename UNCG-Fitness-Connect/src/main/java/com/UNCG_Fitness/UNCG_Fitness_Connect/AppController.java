package com.UNCG_Fitness.UNCG_Fitness_Connect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping({"", "/", "/home", "/index"})
    public String home() {
        return "redirect:/class/all";
    }

}
