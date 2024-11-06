package com.UNCG_Fitness.UNCG_Fitness_Connect.subscription;

import com.UNCG_Fitness.UNCG_Fitness_Connect.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SubscriptionController {

    @Autowired
    SubscriptionService service;

    @Autowired
    UserService userService;

    @GetMapping("/subs/add/{classId}")
    public String createNewSubscription(@PathVariable int classId, @RequestParam String username) {
        long currentUserId = userService.getUserByUserName(username).getUserId();
        service.addNewSubscription(classId, currentUserId);
        return "redirect:/subs/current?username=" + username;
    }

    @GetMapping("/subs/current")
    public String getSubsByCurrentUser(@RequestParam String username, Model model) {
        long currentUserId = userService.getUserByUserName(username).getUserId();
        model.addAttribute("subsList", service.getSubscriptionsByUser(currentUserId));
        model.addAttribute("title", "User #" + currentUserId + " Favorites");
        model.addAttribute("isSubscriber", true);
        return "article/subs-list";
    }

    @GetMapping("/subs/{userId}")
    public String getSubsByUser(@PathVariable long userId, Model model) {
        model.addAttribute("subsList", service.getSubscriptionsByUser(userId));
        model.addAttribute("title", "User #" + userId + " Favorites");
        model.addAttribute("isSubscriber", false);
        return "article/subs-list";
    }

    @GetMapping("/subs/remove/{id}")
    public String removeSub(@PathVariable long id, @RequestParam String username) {
        long currentUserId = userService.getUserByUserName(username).getUserId();
        service.removeSub(id);
        return "redirect:/subs/" + currentUserId;
    }

    @GetMapping("/subs/removeByArticle/{classId}")
    public String removeSubByArticle(@PathVariable int classId, @RequestParam String username) {
        long currentUserId = userService.getUserByUserName(username).getUserId();
        Subscription sub = service.getOneSubscription(classId, currentUserId);
        service.removeSub(sub.getId());
        return "redirect:/subs/" + currentUserId;
    }
}
