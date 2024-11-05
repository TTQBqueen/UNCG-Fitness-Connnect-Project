package com.UNCG_Fitness.UNCG_Fitness_Connect.subscribed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SubscribedService.java
 *
 */
@Service
public class SubscribedService {

    @Autowired
    private SubscribedRepository subscribedRepository;

    /**
     * Subscribe User to a service.
     *
     * @param userId the unique User Id
     * @param classId the unique Class Id
     * @param class_subscribed subscription status
     */
    public Subscribed subscribeToClass(long userId, int classId, Boolean class_subscribed) {
        User existing = getUserId(userId);
        Class existing = getClass(classId)
        existing.setClass_subscribed = true;
    }
}
