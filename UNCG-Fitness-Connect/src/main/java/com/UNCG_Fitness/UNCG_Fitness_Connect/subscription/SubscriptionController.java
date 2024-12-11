package com.UNCG_Fitness.UNCG_Fitness_Connect.subscription;

import com.UNCG_Fitness.UNCG_Fitness_Connect.fitnessClass.Class;
import com.UNCG_Fitness.UNCG_Fitness_Connect.fitnessClass.ClassService;
import com.UNCG_Fitness.UNCG_Fitness_Connect.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/subscription")
public class SubscriptionController {

    @Autowired
    SubscriptionService subscriptionService;

    @Autowired
    UserService userService;

    @Autowired
    ClassService classService;

    /**
     * Create a new Subscription for a Class.
     * http://localhost:8080/subs/add/{classId}/{userId}
     *
     * @param classId the class for the subscription to be assigned to
     * @param userId  the user for whom the subscription is created
     * @return the updated list of subscriptions.
     */
    @PostMapping("/subs/add/{classId}")
    public String createNewSubscription(@PathVariable int classId, @RequestParam int userId) {
        subscriptionService.addNewSubscription(classId, userId);
        return "redirect:/subs/" + userId;
    }

    /**
     * Get all subscriptions for a specific user.
     *
     * @param userId the unique ID of the user.
     * @param model  the model to hold subscription data.
     * @return the subscription list view.
     */
    @GetMapping("/subs/{userId}")
    public String getSubscriptionsByUser(@PathVariable int userId, Model model) {
        model.addAttribute("subscriptions", subscriptionService.getSubscriptionsByUser(userId));
        model.addAttribute("title", "User #" + userId + " Subscriptions");
        model.addAttribute("User Id", userId);
        return "Subscription/subscription";
    }

    /**
     * Remove a subscription by its ID.
     *
     * @param subsId the unique ID of the subscription to remove.
     * @param userId the ID of the current user.
     * @return redirect to the current user's subscriptions.
     */
    @GetMapping("/subs/remove/{subsId}")
    public String removeSubscription(@PathVariable int subsId, @RequestParam int userId) {
        subscriptionService.removeSub(subsId);
        return "redirect:/subs/" + userId;
    }

    /**
     * Remove a subscription by class ID for the current user.
     *
     * @param classId the ID of the class for which to remove the subscription.
     * @param userId  the ID of the current user.
     * @return redirect to the current user's subscriptions.
     */
    @GetMapping("/subs/removeByClass/{classId}")
    public String removeSubscriptionByClass(@PathVariable int classId, @RequestParam int userId) {
        Subscription subscription = subscriptionService.getOneSubscription(classId, userId);
        subscriptionService.removeSub(subscription.getId());
        return "redirect:/subs/" + userId;
    }
}