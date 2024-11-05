package com.UNCG_Fitness.UNCG_Fitness_Connect.Admin; 

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

@Service
public class AdminServices { 

    @Autowired
    AdminRepository adminRepository; 

    @Autowired 
    UserService userService;
    
}
