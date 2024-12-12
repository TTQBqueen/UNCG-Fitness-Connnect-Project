package com.UNCG_Fitness.UNCG_Fitness_Connect.subscription;

import com.UNCG_Fitness.UNCG_Fitness_Connect.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
public class SubscriptionController {

    @Autowired
    SubscriptionService subscriptionService;

    @Autowired
    UserService userService;

    /**
     * Create a new Subscription for a Class.
     * http://localhost:8080/subs/new/{classId} --data '{ "classId": }'
     *
     * @param classId the class for the subscription to be assigned to
     * @return the updated list of subscriptions.
     */
    @PostMapping("/subs/add/{classId}")
    public String createNewSubscription(@PathVariable int classId) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        int currentUserId = userService.getUserByUserName(name).getId();
        return "redirect:/classes/all";
    }

    /**
     * Get a user's subscriptions.
     * http://localhost:8080/subs/2
     *
     * @param subs_id the unique Id for a Student.
     * @return One Subscription object.
     */
    @GetMapping("/subs/{userId}")
    public String getSubsByUser(@PathVariable int userId, Model model) {
        model.addAttribute("subsList", subscriptionService.getSubscriptionsByUser(userId));
        model.addAttribute("class", "User #" + userId + " Favorites");
        model.addAttribute("isSubscriber", false);
        return "Class/class-list";
    }

    public Subscription getSubs(@PathVariable int subs_id) {
        return subscriptionService.getSubscriptionById(subs_id);
    }

    /**
     * Get all users subscribed to a subscription.
     * http://localhost:8080/subs/all/{subs_id}
     *
     * @param userId the unique Id for a subscription.
     * @return all Users connected to the subs_id.
     */
    @GetMapping("/{userId}")
    public List<Subscription> getUsersBySubs(@RequestParam int userId) {
        return subscriptionService.getSubscriptionsByUser(userId);
    }

    /**
     * Remove subscription by Subscription Id.
     * http://localhost:8080/subs/all/{subs_id}
     *
     * @param subs_id the unique Id for a subscription.
     */
    @DeleteMapping("/remove/{subs_id}")
    public void removeSub(@PathVariable int subs_id) {
        subscriptionService.removeSub(subs_id);
    }
}