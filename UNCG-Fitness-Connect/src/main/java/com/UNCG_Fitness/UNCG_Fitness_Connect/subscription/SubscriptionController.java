package com.UNCG_Fitness.UNCG_Fitness_Connect.subscription;

import com.UNCG_Fitness.UNCG_Fitness_Connect.fitnessClass.ClassService;
import com.UNCG_Fitness.UNCG_Fitness_Connect.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class SubscriptionController {

    @Autowired
    SubscriptionService service;

    @Autowired
    UserService userService;

    @GetMapping("/subs/add/{classId}")
    public String createNewSubscription(@PathVariable int classId) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        int currentUserId = userService.getUserByUserName(name).getId();
        service.addNewSubscription(classId, currentUserId);
        return "redirect:/subs/current";
    }

    @GetMapping("/subs/{userId}")
    public String getSubsByUser(@PathVariable int userId, Model model) {
        model.addAttribute("subsList", service.getSubscriptionsByUser(userId));
        return "/User/subs-list";
    }

    @GetMapping("/subs/current")
    public String getSubsByCurrentUser(Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        int currentUserId = userService.getUserByUserName(name).getId();
        model.addAttribute("subsList", service.getSubscriptionsByUser(currentUserId));
        return "/User/subs-list";
    }

    @GetMapping("/subs/remove/{subs_id}")
    public String removeSub(@PathVariable int subs_id) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        int currentUserId = userService.getUserByUserName(name).getId();
        service.removeSub(subs_id);
        return "/User/subs-list";
    }

    @GetMapping("/subs/removeByClass/{classId}")
    public String removeSubByClass(@PathVariable int classId) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        int currentUserId = userService.getUserByUserName(name).getId();
        Subscription sub = service.getOneSubscription(classId, currentUserId);
        service.removeSub(sub.getId());
        return "redirect:/subs/current";
    }
}