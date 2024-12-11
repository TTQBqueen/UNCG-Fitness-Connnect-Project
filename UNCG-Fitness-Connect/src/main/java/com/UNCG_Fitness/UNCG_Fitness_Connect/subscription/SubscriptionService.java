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
    SubscriptionRepository subscriptionRepository;

    @Autowired
    ClassRepository classRepository;

    @Autowired
    UserRepository userRepository;

    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    public Subscription getSubscriptionById(int subs_id) {
        return subscriptionRepository.getReferenceById(subs_id);
    }

    public List<Subscription> getSubscriptionByClassId(int classId) {
        return subscriptionRepository.getSubscriptionsByClass(classId);
    }

    public Subscription getOneSubscription(int classId, int userId) {
        return subscriptionRepository.getOneSubscription(classId, userId);
    }

    public void addNewSubscription(int classId, int userId) {
        Subscription sub = new Subscription(userRepository.getReferenceById(userId),
                classRepository.getReferenceById(classId));

        subscriptionRepository.save(sub);
    }

    public List<Subscription> getSubscriptionsByUser(int userId) {
        return subscriptionRepository.getSubscriptionsByUser(userId);
    }

    public void removeSub(int subs_id) {
        subscriptionRepository.deleteById(subs_id);
    }
}
