package com.UNCG_Fitness.UNCG_Fitness_Connect.Admin;  

import com.UNCG_Fitness.UNCG_Fitness_Connect.user.User;
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.data.jpa.repository.Query; 
import org.springframework.data.jpa.repository.query.Param; 

import java.util.List; 
import java.util.Optional; 

public interface AdminRepository extends JpaRepository<Admin, Long> { 
    Optional<Admin> findByUsername(String username); 

    List<Admin> findByUser(User user); 

    @Query("SELECT a FROM admiin a WHERE a.user.id = :userId")
    List<Admin> findAdminsByUserId(@Param("userId") Long userId);
    
}
