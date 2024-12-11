package com.UNCG_Fitness.UNCG_Fitness_Connect.fitnessClass;

import com.UNCG_Fitness.UNCG_Fitness_Connect.review.Review;
import com.UNCG_Fitness.UNCG_Fitness_Connect.review.ReviewService;
import com.UNCG_Fitness.UNCG_Fitness_Connect.user.User;
import com.UNCG_Fitness.UNCG_Fitness_Connect.user.UserRepository;
import com.UNCG_Fitness.UNCG_Fitness_Connect.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @Autowired
    ReviewService reviewService;


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

        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        long currentUserId = userService.getUserByUserName(name).getId();

        Class fitnessClass = classService.getClassById(classId);
        model.addAttribute("isOwner", fitnessClass.getCreator().getId() == currentUserId);

        // Fetch class details
        model.addAttribute("class", classService.getClassById(classId));
        // Fetch reviews related to the class
        model.addAttribute("reviews", reviewService.getReviewByClassId(classId));
        // Set the page title
        model.addAttribute("title", "Class # " + classId + " Details");
        return "/Class/class-details";
    }



    //  Look up User class based on UserId
    @GetMapping("/INSTRUCTOR/{creatorId}")
    public String getClassesByCreatorId(@PathVariable int creatorId, Model model) {


        model.addAttribute("classList", classService.getClassesByCreatorId(creatorId));
        model.addAttribute("title", "Your Classes: " + creatorId);
        model.addAttribute("creatorId",  creatorId);

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
    @GetMapping("/search")
    public String getClassesByName(@RequestParam(name = "title", defaultValue = "yoga") String title, Model model) {
        model.addAttribute("classList", classService.getClassesByTitle(title));
        model.addAttribute("title", "Class Name: " + title);
        return "/Class/class-list";
    }


    @GetMapping("")
    public String getClassesByTitleContains(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("classList", classService.getClassesByTitleContains(title));
        model.addAttribute("title", "Class Name: " + title);
        return "/Class/class-list";
    }




//Update


    @GetMapping("/update/{classId}")
    public String showUpdateForm(@PathVariable int classId, Model model) {
        model.addAttribute("class", classService.getClassById(classId));
        return "Class/class-update";
    }

    @PostMapping("/INSTRUCTOR/fitnessClass/update")
    public String updateClass(Class fitnessClass) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        fitnessClass.setCreator(userService.getUser(userService.getUserByUserName(name).getId()));
        classService.saveClass(fitnessClass);
        return "redirect:/classes/" + fitnessClass.getClassId();
    }

    @GetMapping("/delete/{classId}")
    public String deleteClassById(@PathVariable int classId) {
        classService.deleteClassById(classId);
        return "redirect:/classes/all";
    }


    @PostMapping("/new")
    public String addNewClass(Class fitnessClass) {
        classService.saveClass(fitnessClass);
        return "redirect:/classes/all";
    }




//    getting all users that have the instructor role

    @GetMapping("/instructors")
    public String getInstructors(Model model) {
        List<User> instructors = userRepository.findByRole("INSTRUCTOR");
        model.addAttribute("userList", instructors);
        return "/Class/inst_view";
    }


    @GetMapping("/INSTRUCTOR/fitnessClass/createForm")
    public String showCreateClassForm() {
        return "Class/create-class";
    }

    @PostMapping("/INSTRUCTOR/fitnessClass/new")
    public String createClass( Class fitnessClass) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        fitnessClass.setCreator(userService.getUser(userService.getUserByUserName(name).getId()));
        classService.saveClass(fitnessClass);
        return "redirect:/classes/all";
    }

}
