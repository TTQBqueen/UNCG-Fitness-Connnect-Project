package com.UNCG_Fitness.UNCG_Fitness_Connect.Admin; 

import com.UNCG_Fitness.UNCG_Fitness_Connect.user.User; 
import com.UNCG_Fitness.UNCG_Fitness_Connect.user.UserRepository; 

import org.springframework.beans.factory.annotation.Autowired; 

import org.springframework.stereotype.Service;

import java.util.List; 
import java.util.Optional;

@Service 
public class AdminService{  
    @Autowired 
    UserRepository userRepository; 
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    } 
    public User updateUserAccountStatus(int userId, String accountStatus){ 
        Optional<User> userOptional = userRepository.findById(userId); 
        if (userOptional.isPresent()){ 
            User user = userOptional.get(); 
            user.setAccountStatus(accountStatus); 
            return userRepository.save(user);
        } 
        return null;
    }
}