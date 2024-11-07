package com.UNCG_Fitness.UNCG_Fitness_Connect.Admin; 

import com.UNCG_Fitness.UNCG_Fitness_Connect.user.User; 
import com.UNCG_Fitness.UNCG_Fitness_Connect.Review.Review;  
import com.UNCG_Fitness.UNCG_Fitness_Connect.Service.Service;  
import com.UNCG_Fitness.UNCG_Fitness_Connect.Statistics.UsageStatistics;  
import com.UNCG_Fitness.UNCG_Fitness_Connect.user.UserService; 
import com.UNCG_Fitness.UNCG_Fitness_Connect.Review.ReviewService; 
import com.UNCG_Fitness.UNCG_Fitness_Connect.Service.ServiceService;  
import com.UNCG_Fitness.UNCG_Fitness_Connect.Statistics.UsageStatisticsService;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import java.util.List; 
import java.util.Optional;

@Service
public class AdminServices { 

    @Autowired
    private AdminRepository adminRepository; 
    
    @Autowired 
    private UserService userService; 

    @Autowired  
    private ReviewService reviewService; 

    @Autowired  
    private ServiceService serviceService; 
    
    @Autowired 
    private UsageStatisticsService usageStatisticsService;  

    public boolean updateUserAccountStatus(int userId, String newStatus){
        Optional<User> user = userService.getUserById(userId); 
        if(user.isPresent()){ 
            user.get().setAccountStatus(newStatus); 
            userService.saveUser(user.get());  
            return true;
    } 
    return false; 
} 
    public List<Review> getReviewsForService(int serviceId){ 
        return reviewService.getReviewsByServiceId(serviceId); 
    }
    public boolean deleteService(int serviceId){  
        if(serviceService.existsByServiceId(serviceId)){ 
            serviceService.deleteByServiceId(serviceId);
            return true; 
        } 
        return false;
    } 
    public List<Review> getAllReviews(){ 
        return reviewService.getAllReviews();
    } 
    public boolean deleteReview(int reviewId){  
        if(reviewService.existsByReviewId(reviewId)){ 
            reviewService.deleteByReviewId(reviewId);
            return true; 
        } 
        return false;
    } 
    public List <Review> getAllReplies(){ 
        return reviewService.getAllReplies();
    } 
    public boolean deleteReply(int replyId){ 
        if(reviewService.existsByReplyId(replyId)){ 
            reviewService.deleteByReplyId(replyId);
            return true; 
        } 
        return false;
    } 
    public List<UsageStatistics> getAllStatistics(){ 
        return usageStatisticsService.getAllStatistics();
    }
}
