package com.UNCG_Fitness.UNCG_Fitness_Connect.Admin;   

import jakarta.persistence.*;  

@Entity
@Table(name = "admin")
public class Admin { 

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private int adminId; 
 
    @Column(nullable = false) 
    private String username;  
    
    @Column(nullable = false)  
    private String role; 

    private String accountStatus;

    public Admin() { 
    } 
    public Admin(int adminId, String username, String role) {  
        this.adminId = adminId;
        this.username = username;
        this.role = role; 
    } 
    
    public int getAdminId() {
        return adminId;
    } 
    public void setAdminId(int adminId) { 
        this.adminId = adminId;
    } 
    public String getUsername() {
        return username;
    } 
    public void setUsername(String username) {
        this.username = username;
    } 
    public String getRole() {
        return role;
    } 
    public void setRole(String role) {
        this.role = role; 
    }  
}