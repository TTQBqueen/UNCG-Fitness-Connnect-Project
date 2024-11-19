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
@RequestMapping("/subs")
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
    @PostMapping("/add/{classId}/{userId}")
    public String createNewSubscription(@PathVariable int classId, @PathVariable int userId, Model model) {
        subscriptionService.addNewSubscription(classId, userId);
        List<Subscription> subscriptions = subscriptionService.getSubscriptionByClassId(classId);
        model.addAttribute("subscriptions", subscriptions);
        return "Subscription/subscription";
    }

    /**
     * Get a list of all Subscriptions in the database.
     * http://localhost:8080/subs/all
     *
     * @return a list of Subscription objects.
     */
    @GetMapping("/all")
    String getAllSubscriptions(Model model) {
        List<Subscription> subscriptions = subscriptionService.getAllSubscriptions();
        model.addAttribute("subscriptions", subscriptions);
        return "Subscription/subscription";
    }

    /**
     * Get a specific Subscription by Subscription Id.
     * http://localhost:8080/subs/{subs_id}
     *
     * @param subs_id the unique Id for a Student.
     * @return One Subscription object.
     */
    @GetMapping("/{subs_id}")
    public String getSubscription(@PathVariable int subs_id, Model model) {
        Subscription subscription = subscriptionService.getSubscriptionById(subs_id);
        model.addAttribute("subscription", subscription);
        return "Subscription/subscription";
    }

    /**
     * Get all subscriptions for a specific user.
     * http://localhost:8080/subs/user/{userId}
     *
     * @param userId the unique Id for a subscription.
     * @return all Users connected to the subs_id.
     */
    @GetMapping("/user/{userId}")
    public String getSubscriptionsByUser(@PathVariable int userId, Model model) {
        List<Subscription> subscriptions = subscriptionService.getSubscriptionsByUser(userId);
        model.addAttribute("subscriptions", subscriptions);
        return "Subscription/subscription";
    }

    /**
     * Remove subscription by Subscription Id.
     * http://localhost:8080/subs/all/{subs_id}
     *
     * @param subs_id the unique Id for a subscription.
     */
    @DeleteMapping("/remove/{subs_id}")
    public String removeSubscription(@PathVariable int subs_id) {
        subscriptionService.removeSub(subs_id);
        return "redirect:/User/all"; // Redirects to the list of all subscriptions after deletion
    }
}