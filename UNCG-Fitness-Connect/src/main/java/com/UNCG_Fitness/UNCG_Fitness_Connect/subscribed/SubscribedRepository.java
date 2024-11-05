package com.UNCG_Fitness.UNCG_Fitness_Connect.subscribed;

import com.UNCG_Fitness.UNCG_Fitness_Connect.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface SubscribedRepository extends JpaRepository<Subscribed, Boolean> {

    Optional<Subscribed> findBySubscribed(Boolean class_subscribed);

}
