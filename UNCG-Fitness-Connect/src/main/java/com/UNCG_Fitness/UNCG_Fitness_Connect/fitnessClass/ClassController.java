package com.UNCG_Fitness.UNCG_Fitness_Connect.fitnessClass;

import com.UNCG_Fitness.UNCG_Fitness_Connect.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/class")
public class ClassController {

    @Autowired
    ClassService classService;
    
    @Autowired
    UserService userService;
    
//    All Class
@GetMapping("/all")
public String getAllClasses(Model model) {
    model.addAttribute("classList", classService.getAllClasses());
    model.addAttribute("title", "All Class");
    return "/Class/class-list";
}

//    Look up User class based on ID
@GetMapping("/user/{userId}")
public String getClassesByUser(@PathVariable long userId,Model model) {
    model.addAttribute("classList", classService.getAllUserClasses(userId));
    model.addAttribute("title", "Your Classes: "+userId);
    return "/Class/class-list";
}
//Class by ID
    @GetMapping("/{id}")
    public String getClassesById(@PathVariable int id, Model model) {
        model.addAttribute("class", classService.getClassById(id));
        model.addAttribute("title", "Class # "+id+" Details");
        return "/Class/class-detail";
    }

//    Create Class
    
//    Update
    
//    Delete
}
