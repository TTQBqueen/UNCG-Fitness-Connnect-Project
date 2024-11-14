package com.UNCG_Fitness.UNCG_Fitness_Connect.subscription;

import com.UNCG_Fitness.UNCG_Fitness_Connect.fitnessClass.Class;
import com.UNCG_Fitness.UNCG_Fitness_Connect.fitnessClass.ClassRepository;
import com.UNCG_Fitness.UNCG_Fitness_Connect.user.User;
import com.UNCG_Fitness.UNCG_Fitness_Connect.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SubscriptionService.java
 *
 */
@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscribedRepository;

    @Autowired
    ClassRepository classRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SubscriptionRepository subscriptionRepository;

    public List<Subscription> getAllSubscriptions() {
        return subscribedRepository.findAll();
    }

    public Subscription getSubscriptionById(int subs_id) {
        return subscribedRepository.getReferenceById(subs_id);
    }

    public List<Subscription> getSubscriptionByClassId(int classId) {
        return subscribedRepository.getSubscriptionsByClass(classId);
    }

    public void addNewSubscription(int classId, int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User no found with Id: " + userId));
        Class fitnessClass = classRepository.findById(classId)
                .orElseThrow(() -> new IllegalArgumentException("Class not found with Id: " + classId));

        if (subscriptionRepository.getOneSubscription(classId, userId) == null) {
            Subscription sub = new Subscription(user, fitnessClass);
            subscriptionRepository.save(sub);
        } else {
            throw new IllegalArgumentException("Subscription already exists for user ID " + userId + " and class ID " + classId);
        }
    }

    public List<Subscription> getSubscriptionsByUser(int userId) {
        return subscribedRepository.getSubscriptionsByUser(userId);
    }

    public void removeSub(int subs_id) {
        subscribedRepository.deleteById(subs_id);
    }

}
