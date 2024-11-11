package com.UNCG_Fitness.UNCG_Fitness_Connect.fitnessClass;

import com.UNCG_Fitness.UNCG_Fitness_Connect.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    //Class by ID
    @GetMapping("/{classId}")
    public String getClassesById(@PathVariable int classId, Model model) {
        model.addAttribute("class", classService.getClassById(classId));
        model.addAttribute("title", "Class # "+classId+" Details");
        return "/Class/class-details";
    }

    //  Look up User class based on UserId
    @GetMapping("/INSTRUCTOR/{creatorId}")
    public String getClassesByCreatorId(@PathVariable int creatorId, Model model) {
        model.addAttribute("classList", classService.getClassesByCreatorId(creatorId));
        model.addAttribute("title", "Your Classes: " + creatorId);
        return "/Class/class-list";
    }


    /**
     * Get a list of Classes based on their level.
     * http://localhost:8080/classes/level
     *
     * @param level the search key.
     * @return A list of Classes objects matching the level key.
     */

    @GetMapping("/levels")
    public String getClassesByLevel(@RequestParam(name = "level", defaultValue = "BEGINNER") String level, Model model) {
        model.addAttribute("classList", classService.getClassesByLevel(level));
        model.addAttribute("title", "Class Name: " + level);
        return "/Class/class-list";
    }


    /**
     * Get a list of Classes based on their name.
     * http://localhost:8080/classes?title=yoga
     *
     * @param title the search key.
     * @return A list of Class objects matching the search key.
     */
    @GetMapping("")
    public String getClassesByName(@RequestParam(name = "title", defaultValue = "yoga") String title, Model model) {
        model.addAttribute("classList", classService.getClassesByTitle(title));
        model.addAttribute("title", "Class Name: " + title);
        return "/Class/class-list";
    }


    @GetMapping("/search")
    public String getAnimalsByNameContains(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("classList", classService.getClassesByTitleContains(title));
        model.addAttribute("title", "Class Name: " + title);
        return "/Class/class-list";
    }

    //    Create Class
    @PostMapping("/new")
    public String addNewAnimal(@ModelAttribute("class") Class fitnessclass) {
        classService.addNewClass(fitnessclass);
        return "redirect:/class/all";
    }

    //Create new Class Form
    @GetMapping("/createForm")
    public String showCreateForm(Model model) {
        Class fitnessclass = new Class();
        //attach user list
        model.addAttribute("classList", classService.getAllClasses());
        return "Class/class-create";
    }
//Update

    /**
     * Show the update form.
     *
     * @param classId
     * @param model
     * @return
     */
    @GetMapping("/update/{classlId}")
    public String showUpdateForm(@PathVariable int classId, Model model) {
        model.addAttribute("class", classService.getClassById(classId));
        return "Class/class-update";
    }


    /**
     * Perform the update.
     *
     * @param fitnessClass
     * @return
     */
    @PostMapping("/update")
    public String updateClass(Class fitnessClass) {
        classService.addNewClass(fitnessClass);
        return "redirect:/classes/" + fitnessClass.getClassId();
    }

}