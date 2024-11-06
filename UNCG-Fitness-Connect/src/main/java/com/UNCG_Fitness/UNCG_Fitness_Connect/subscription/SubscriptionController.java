package com.UNCG_Fitness.UNCG_Fitness_Connect.subscription;

import com.UNCG_Fitness.UNCG_Fitness_Connect.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subs")
public class SubscriptionController {

    @Autowired
    SubscriptionService subscriptionService;

    @Autowired
    UserService userService;

    /**
     * Get a list of all Subscriptions in the database.
     * http://localhost:8080/subs/all
     *
     * @return a list of Subscription objects.
     */
    @GetMapping("/all")
    public List<Subscription> getAllStudents() {
        return subscriptionService.getAllSubscriptions();
    }

    /**
     * Get a specific Subscription by Subscription Id.
     * http://localhost:8080/subs/2
     *
     * @param subs_id the unique Id for a Student.
     * @return One Subscription object.
     */
    @GetMapping("/{subs_id}")
    public int getSubs(@PathVariable int subs_id) {
        return subscriptionService.getSubscriptionById(subs_id);
    }

    /**
     * Create a new Subscription for a Class.
     * http://localhost:8080/subs/new/{classId} --data '{ "classId": }'
     *
     * @param classId the class for the subscription to be assigned to
     * @param subscription new subscription object.
     * @return the updated list of subscriptions.
     */
    @PostMapping("/new/{classId}")
    public String createNewSubscription(@PathVariable int classId, @RequestBody Subscription subscription) {
        SubscriptionService.addNewSubscription(classId, subscription);
            return SubscriptionService.getAllSubscriptions();
    }

    /**
     * Get all users subscribed to a subscription.
     * http://localhost:8080/subs/all/{subs_id}
     *
     * @param userId the unique Id for a subscription.
     * @return all Users connected to the subs_id.
     */
    @GetMapping("/subs/{userId}")
    public List<Subscription> getUsersBySubs(@RequestParam int userId) {
        subscriptionService.getSubscriptionsByUser(userId);
            return subscriptionService.getSubscriptionById(userId);
    }

    //delete function

}