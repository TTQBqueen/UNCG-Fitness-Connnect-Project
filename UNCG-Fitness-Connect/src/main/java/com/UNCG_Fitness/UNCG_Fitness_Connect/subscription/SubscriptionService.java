package com.UNCG_Fitness.UNCG_Fitness_Connect.subscription;

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
        Subscription sub = new Subscription(userRepository.getReferenceById(userId),
                classRepository.getReferenceById(classId));

        subscribedRepository.save(sub);
    }

    public List<Subscription> getSubscriptionsByUser(int userId) {
        return subscribedRepository.getSubscriptionsByUser(userId);
    }

    public void removeSub(int subs_id) {
        subscribedRepository.deleteById(subs_id);
    }

}
