package com.UNCG_Fitness.UNCG_Fitness_Connect.subscription;

import com.UNCG_Fitness.UNCG_Fitness_Connect.fitnessClass.ClassRepository;
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

    public Subscription getSubscriptionById(long id) {
        return subscribedRepository.getReferenceById(id);
    }

    public List<Subscription> getSubscriptionByClassId(int id) {
        return subscribedRepository.getSubscriptionsByClass(id);
    }

    public Subscription getOneSubscription(int classId, long userId) {
        return subscribedRepository.getOneSubscription(classId, userId);
    }


    public void addNewSubscription(int classId, long userId) {
        Subscription sub = new Subscription(userRepository.getReferenceById(userId),
                classRepository.getReferenceById(classId));

        subscribedRepository.save(sub);
    }

    public List<Subscription> getSubscriptionsByUser(long userId) {
        return subscribedRepository.getSubscriptionsByUser(userId);
    }

    public void removeSub(long id) {
        subscribedRepository.deleteById(id);
    }
}
