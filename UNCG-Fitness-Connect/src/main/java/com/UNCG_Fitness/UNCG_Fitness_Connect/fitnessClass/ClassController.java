package com.UNCG_Fitness.UNCG_Fitness_Connect.fitnessClass;

import com.UNCG_Fitness.UNCG_Fitness_Connect.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/classes")
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
    return "/Class/inst_view";
}
//Class by ID
    @GetMapping("/{classId}")
    public String getClassesById(@PathVariable int classId, Model model) {
        model.addAttribute("class", classService.getClassById(classId));
        model.addAttribute("title", "Class # "+classId+" Details");
        return "/Class/class-details";
    }


//    Create Class
@PostMapping("/new")
public String addNewAnimal(@ModelAttribute("class") Class class) {
    classService.addNewClass(class);
    return "redirect:/class/all";
}

    @GetMapping("/createForm")
    public String showCreateForm(Model model) {
        Class class = new Class();
        //attach user list
        model.addAttribute("classList", classService.getAllClasses());
        return "/class-create";
    }

//    Update
    
//    Delete
}
