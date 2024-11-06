package com.UNCG_Fitness.UNCG_Fitness_Connect.user;

import com.UNCG_Fitness.UNCG_Fitness_Connect.fitnessClass.Class;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> getUsersByRole(String role);
    //returns animals with name
    List<User> getUsersByUserName(String userName);


}
