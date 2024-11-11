package com.UNCG_Fitness.UNCG_Fitness_Connect.fitnessClass;

import com.UNCG_Fitness.UNCG_Fitness_Connect.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

<<<<<<< Updated upstream
@RestController
=======
@Controller
>>>>>>> Stashed changes
@RequestMapping("/classes")
public class ClassController {

    @Autowired
    ClassService classService;

    @Autowired
    UserService userService;
<<<<<<< Updated upstream


//    All Class
    /**
     * Get a list of all Classes .
     * http://localhost:8080/classes/all
     *
     * @return a list of Class  objects.
     */
    @GetMapping("/all")
    public List<Class> getAllClasses() {
        return classService.getAllClasses();
    }


    /**
     * Get a specific class by Id.
     * http://localhost:8080/classes/2
     *
     * @param classId the unique Id for a Classes.
     * @return One Class object.
     */
=======

    //    All Class
    @GetMapping("/all")
    public String getAllClasses(Model model) {
        model.addAttribute("classList", classService.getAllClasses());
        model.addAttribute("title", "All Class");
        return "/Class/class-list";
    }


    //Class by classID
>>>>>>> Stashed changes
    @GetMapping("/{classId}")
    public Class getOneClass(@PathVariable int classId) {
        return classService.getClassById(classId);
    }


<<<<<<< Updated upstream
//    IDK if it work until i get the user table

    /**
     * Get a specific class by Id.
     * http://localhost:8080/classes/2
     *
     * @param creatorId the unique Id for a Classes.
     * @return A list of Classes objects matching the creatorId key..
     */
    @GetMapping("INSTRUCTOR/{creatorId}")
    public List<Class> getClassesByCreatorId(@PathVariable int creatorId) {
        return classService.getClassesByCreatorId(creatorId);
=======

    //  Look up User class based on UserId
    @GetMapping("/INSTRUCTOR/{creatorId}")
    public String getClassesByCreatorId(@PathVariable int creatorId, Model model) {
        model.addAttribute("classList", classService.getClassesByCreatorId(creatorId));
        model.addAttribute("title", "Your Classes: "+creatorId);
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
        return "class-list";
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
        return "class-list";
    }



    @GetMapping("/search")
    public String getAnimalsByNameContains(@RequestParam(name = "title",  required = false) String title, Model model) {
        model.addAttribute("classList", classService.getClassesByTitleContains(title));
        model.addAttribute("title", "Class Name: " + title);
        return "class-list";
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
        return "/class-create";
>>>>>>> Stashed changes
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
        return "class-update";
    }

<<<<<<< Updated upstream

    /**
     * Get a list of Classes based on their level.
     * http://localhost:8080/classes/level
     *
     * @param level the search key.
     * @return A list of Classes objects matching the level key.
     */

    @GetMapping("/levels")
    public List<Class> getClassesByLevel(@RequestParam(name = "level", defaultValue = "BEGINNER") String level) {
        return classService.getClassesByLevel(level);
    }

    /**
     * Get a list of Classes based on their name.
     * http://localhost:8080/classes?title=yoga
     *
     * @param title the search key.
     * @return A list of Class objects matching the search key.
     */
    @GetMapping("")
    public List<Class> getClassesByName(@RequestParam(name = "title", defaultValue = "yoga") String title) {
        return classService.getClassesByTitle(title);
    }

    /**
     * Get a list of Classes based on their title.
     * http://localhost:8080/classes/search?title=yoga
     *
     * @param title the search key.
     * @return A list of Class objects matching the search key.
     */
    @GetMapping("/search")
    public List<Class> getClassesByNameContains(@RequestParam(name = "title", required = false) String title) {
        return classService.getClassesByTitleContains(title);
    }

    /**
     * Create a new Classes entry.
     * http://localhost:8080/classes/new --data '{ "ClassId": 4, "name": "sample4", "major": "csc", "gpa": 3.55}'
     *
     * @param fitnessClass the new Class object.
     * @return the updated list of Classes.
     */
    @PostMapping("/new")
    public List<Class> addNewClass(@RequestBody Class fitnessClass) {
        classService.addNewClass(fitnessClass);
        return classService.getAllClasses();
    }

    /**
     * Update an existing Class object.
     * http://localhost:8080/Classes/update/2 --data '{
     * "classId": 1, "title": "cat", "ScientificName": "Felion", "Classification": "manmmal", "Habitat": "outside" , "Description": "this is a cat" }'
     *
     * @param classId      the unique Class Id.
     * @param fitnessClass the new update Class details.
     * @return the updated Class object.
     */
    @PutMapping("/update/{classId}")
    public Class updateClass(@PathVariable int classId, @RequestBody Class fitnessClass) {
        classService.updateClass(classId, fitnessClass);
        return classService.getClassById(classId);
    }
=======
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

>>>>>>> Stashed changes

    /**
     * Delete a Animal object.
     * http://localhost:8080/classes/delete/2
     *
     * @param classId the unique Animal Id.
     * @return the updated list of Animals.
     */
    @DeleteMapping("/delete/{classId}")
    public List<Class> deleteClassById(@PathVariable int classId) {
        classService.deleteClassById(classId);
        return classService.getAllClasses();
    }

}