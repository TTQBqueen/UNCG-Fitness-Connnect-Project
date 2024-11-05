package com.UNCG_Fitness.UNCG_Fitness_Connect.Admin; 
import jakarta.persistence.Entity; 
import jakarta.persistence.*;  
import org.springframework.lang.NonNull; 

import java.sql.Date; 

@Entity 
@Table(name = "admin")

public class admin { 

@Id 
@GeneratedValue(strategy = GenerationType.AUTO) 
private int id; 

@ManytoOne  
@JoinColumn(name = "user_id") 
private User user;  

@Column(nullable = false) 
private String username;   

public admin(int userId, String username) {

public Admin getAdmin() { 
}

    
}
