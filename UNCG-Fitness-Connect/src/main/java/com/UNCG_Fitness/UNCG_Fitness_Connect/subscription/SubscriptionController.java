package com.UNCG_Fitness.UNCG_Fitness_Connect.subscription;

import com.UNCG_Fitness.UNCG_Fitness_Connect.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SubscriptionController {

    @Autowired
    SubscriptionService subscriptionService;

    @Autowired
    UserService userService;

    /**
     * Create a new Subscription for a Class.
     * http://localhost:8080/subs/add/{classId}
     *
     * @param classId the class for the subscription to be assigned to
     * @return redirect to the current user's subscriptions.
     */
    @PostMapping("/subs/add/{classId}")
    public String createNewSubscription(@PathVariable int classId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        int currentUserId = userService.getUserByUserName(username).getId();
        subscriptionService.addNewSubscription(classId, currentUserId);
        return "redirect:/subs/current";
    }

    /**
     * Get all subscriptions for a specific user.
     *
     * @param userId the unique Id of the user.
     * @param model  the model to hold subscription data.
     * @return the subscription list view.
     */
    @GetMapping("/subs/{userId}")
    public String getSubscriptionsByUser(@PathVariable int userId, Model model) {
        model.addAttribute("subscriptions", subscriptionService.getSubscriptionsByUser(userId));
        model.addAttribute("title", "User #" + userId + " Subscriptions");
        return "Subscription/subscription-list";
    }

    /**
     * Get all subscriptions for the current authenticated user.
     *
     * @param model the model to hold subscription data.
     * @return the subscription list view.
     */
    @GetMapping("/subs/current")
    public String getSubscriptionsByCurrentUser(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        int currentUserId = userService.getUserByUserName(username).getId();
        model.addAttribute("subscriptions", subscriptionService.getSubscriptionsByUser(currentUserId));
        model.addAttribute("title", "Your Subscriptions");
        return "Subscription/subscription-list";
    }

    /**
     * Remove a subscription by its ID.
     *
     * @param subs_id the unique ID of the subscription to remove.
     * @return redirect to the current user's subscriptions.
     */
    @GetMapping("/subs/remove/{subs_id}")
    public String removeSubscription(@PathVariable int subs_id) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        int currentUserId = userService.getUserByUserName(username).getId();
        subscriptionService.removeSub(subs_id);
        return "redirect:/subs/" + currentUserId;
    }

    /**
     * Remove a subscription by class ID for the current user.
     *
     * @param classId the ID of the class for which to remove the subscription.
     * @return redirect to the current user's subscriptions.
     */
    @GetMapping("/subs/removeByClass/{classId}")
    public String removeSubscriptionByClass(@PathVariable int classId) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        int currentUserId = userService.getUserByUserName(username).getId();
        Subscription subscription = subscriptionService.getOneSubscription(classId, currentUserId);
        subscriptionService.removeSub(subscription.getId());
        return "redirect:/subs/" + currentUserId;
    }
}