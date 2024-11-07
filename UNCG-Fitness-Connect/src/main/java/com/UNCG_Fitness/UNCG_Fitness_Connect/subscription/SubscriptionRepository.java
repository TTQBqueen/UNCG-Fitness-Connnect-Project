package com.UNCG_Fitness.UNCG_Fitness_Connect.subscription;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
    @Query(value = "select * from subscriptions where user_id = :userId", nativeQuery = true)
    List<Subscription> getSubscriptionsByUser(int userId);

    @Query(value = "select * from subscriptions where class_id = :classId", nativeQuery = true)
    List<Subscription> getSubscriptionsByClass(int classId);

    @Query(value = "select * from subscriptions where class_id = :classId and user_id = :userId", nativeQuery = true)
    Subscription getOneSubscription(int classId, int userId);
}
