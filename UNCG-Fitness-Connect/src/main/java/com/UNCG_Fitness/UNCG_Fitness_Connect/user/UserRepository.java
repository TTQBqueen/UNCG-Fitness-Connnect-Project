package com.UNCG_Fitness.UNCG_Fitness_Connect.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {


        List<User> findByRole(String role);
//    Optional<User> findByUserName(String userName);

}
