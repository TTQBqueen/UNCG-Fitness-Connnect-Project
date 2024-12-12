package com.UNCG_Fitness.UNCG_Fitness_Connect.subscription;

import com.UNCG_Fitness.UNCG_Fitness_Connect.fitnessClass.ClassService;
import com.UNCG_Fitness.UNCG_Fitness_Connect.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubscriptionController {

    @Autowired
    SubscriptionService service;

    @Autowired
    UserService userService;

    @Autowired
    private ClassService classService;

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
        model.addAttribute("title", "User #" + userId + " Subscriptions");
        model.addAttribute("isSubscriber", false);
        return "User/subs-list";
    }

    @GetMapping("/subs/current")
    public String getSubsByCurrentUser(Model model) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        int currentUserId = userService.getUserByUserName(name).getId();
        model.addAttribute("subsList", service.getSubscriptionsByUser(currentUserId));
        model.addAttribute("title", "User #" + currentUserId + " Subscriptions");
        model.addAttribute("isSubscriber", true);
        return "User/subs-list";
    }

    @GetMapping("/subs/remove/{subs_id}")
    public String removeSub(@PathVariable int subs_id) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        int currentUserId = userService.getUserByUserName(name).getId();
        service.removeSub(subs_id);
        return "redirect:/subs/" + currentUserId;
    }

    @GetMapping("/subs/removeByClass/{classId}")
    public String removeSubByClass(@PathVariable int classId) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        int currentUserId = userService.getUserByUserName(name).getId();
        Subscription sub = service.getOneSubscription(classId, currentUserId);
        service.removeSub(sub.getId());
        return "redirect:/subs/" + currentUserId;
    }

//    /**
//     * Get all subscriptions.
//     * http://localhost:8080/subs/all
//     */
//    @GetMapping("/all")
//    public String getAllSubscriptions(Model model) {
//        model.addAttribute("subscriptionList", subscriptionService.getAllSubscriptions());
//        return "Subscription/subscription";
//    }
//
//    /**
//     * Create a new Subscription for a Class.
//     * http://localhost:8080/subs/new/{classId} --data '{ "classId": }'
//     *
//     * @param classId the class for the subscription to be assigned to
//     * @return the updated list of subscriptions.
//     */
//    @PostMapping("/subs/add/{classId}")
//    public List<Subscription> createNewSubscription(@PathVariable int classId, @PathVariable int userId) {
//        subscriptionService.addNewSubscription(classId, userId);
//        return subscriptionService.getSubscriptionByClassId(classId);
//    }
//
//
//    /**
//     * Get a list of all Subscriptions in the database.
//     * http://localhost:8080/subs/all
//     *
//     * @return a list of Subscription objects.
//     */
//    @GetMapping("/all")
//    public List<Subscription> getAllStudents() {
//        return subscriptionService.getAllSubscriptions();
//    }
//
//    /**
//     * Get a specific Subscription by Subscription Id.
//     * http://localhost:8080/subs/2
//     *
//     * @param subs_id the unique Id for a Student.
//     * @return One Subscription object.
//     */
//    @GetMapping("/subs/current")
//    public Subscription getSubs(@PathVariable int subs_id) {
//        return subscriptionService.getSubscriptionById(subs_id);
//    }
//
//    /**
//     * Get all users subscribed to a subscription.
//     * http://localhost:8080/subs/all/{subs_id}
//     *
//     * @param userId the unique Id for a subscription.
//     * @return all Users connected to the subs_id.
//     */
//    @GetMapping("/subs/{userId}")
//    public List<Subscription> getUsersBySubs(@RequestParam int userId) {
//        return subscriptionService.getSubscriptionsByUser(userId);
//    }
//
//    /**
//     * Remove subscription by Subscription Id.
//     * http://localhost:8080/subs/all/{subs_id}
//     *
//     * @param subs_id the unique Id for a subscription.
//     */
//    @DeleteMapping("/remove/{subs_id}")
//    public void removeSub(@PathVariable int subs_id) {
//        subscriptionService.removeSub(subs_id);
//    }
}