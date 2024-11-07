package com.UNCG_Fitness.UNCG_Fitness_Connect.Admin; 

import com.UNCG_Fitness.UNCG_Fitness_Connect.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;  

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController { 
    
    @Autowired
    AdminService adminService;  
    
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return adminService.getAllUsers();
    } 
    @PutMapping("/user/update/{userId}") 
    public User updateUserAccountStatus(@PathVariable int userId, @RequestBody String newAccountStatus){ 
        return adminService.updateUserAccountStatus(userId, newAccountStatus);
    } 
}
