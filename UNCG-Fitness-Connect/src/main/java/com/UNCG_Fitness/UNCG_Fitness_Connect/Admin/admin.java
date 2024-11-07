package com.UNCG_Fitness.UNCG_Fitness_Connect.Admin;  

import com.UNCG_Fitness.UNCG_Fitness_Connect.user.User;  
import com.UNCG_Fitness.UNCG_Fitness_Connect.Service.Service; 
import com.UNCG_Fitness.UNCG_Fitness_Connect.Review.Review; 
import com.UNCG_Fitness.UNCG_Fitness_Connect.Statistics.UsagStatistics
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.persistence.Entity; 
import jakarta.persistence.*;  
 
import java.util.List;  


@Entity
@Table(name = "admin")
public class Admin { 

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private int id; 

    @ManyToOne  
    @JoinColumn(name = "user_id", nullable = false) 
    private User user;  

    @Column(nullable = false) 
    private String username;  
    
    @Autowired 
    private ReviewService reviewService; 

    @Autowired 
    private ServiceService serviceService;

    public Admin() { 
    }

    public Admin(User user, String username) {  
        this.user = user; 
        this.username = username;
    }  
    public int getId(){ 
        return id;
    } 
    public void setId(int id){ 
        this.id = id;
    }
    public User getUser(){  
        return user;
    } 
    public void setUser(User user) {  
        this.user = user;
    } 
    public String getUsername(){ 
        return username; 
    } 
    public void setUsername(String username) {  
        this.username = username;
    }    
    public void manageUserAccess(User user, String newAccountStatus){ 
        user.setAccountStatus(newAccountStatus);
    } 
    public List<Review> getAllReviewsForService(Service service){ 
        return reviewService.getReviewsByService(service);
    } 
    public void deleteService(Service service){
        serviceService.deleteServiceById(service.getId()); 

    } 
    public List<Review> getAllReviews(){ 
        return null;
    } 
    public void deleteReview(Review review){ 
        reviewService.deleteReviewById(review.getId());
    } 
    public List<UsageStatistics> getAllStatistics(){ 
        return null;
    } 
@Override 
public String toString(){ 
    return "Admin{" + 
            "id=" + id +
            ", user=" + user +
            ", username='" + username + '\'' +
            '}';
}
 }

