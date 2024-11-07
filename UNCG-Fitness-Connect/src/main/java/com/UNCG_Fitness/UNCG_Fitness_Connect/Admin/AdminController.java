package com.UNCG_Fitness.UNCG_Fitness_Connect.Admin; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.*; 

@Controller 
@RequestMapping("/admin")
public class AdminController { 
    
    @Autowired
    private UserService userService; 

    @Autowired 
    private ReviewService reviewService;  

    @Autowired  
    private ServiceService serviceService;  

    @Autowired 
    private UsageStatisticsService usageStatisticsService;

    //Manage Users 
    @GetMapping("/manage-users")
    public String manageUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/manage-users";
    } 
    @PatchMapping("/update-user/{user_id}") 
    public String updateUserAccountStatus(@PathVariable int userId, @RequestParam("status") String newStatus){ 
        User user = userService.getUserById(userId);
        if(user!=null){
            user.setAccountStatus(newStatus);
            userService.saveUser(user);
            return "redirect:/admin/manage-users";
    } 
    @GetMapping("/service/{serviceId}/reviews") 
    public String getReviewsForService(@PathVariable int serviceId, Model model){ 
        List<Review> reviews = reviewService.getReviewsByServiceId(serviceId); 
        model.addAttribute("reviews", reviews); 
        model.addAttribute("serviceId", serviceId); 
        return "admin/service-reviews";
    } 
    @PostMapping("/service/delete/{serviceId}")
    public String deleteService(@PathVariable int serviceId){
        serviceService.deleteServiceById(serviceId);
        return "redirect:/admin/manage-services";
    } 
    @GetMapping("/reviews")} 
    public String getAllReviews(Model model){ 
        List<Review> reviews = reviewService.getAllReviews();
        model.addAttribute("reviews", reviews);
        return "admin/reviews";
    }  
    @PostMapping("/review/delete/{reviewId}")
    public String deleteReview(@PathVariable int reviewId){ 
        reviewService.deleteReviewById(reviewId);
        return "redirect:/admin/reviews";
    } 
    @GetMapping("/replies") 
    public String getALlReplies(Model model){ 
        List<Review> replies = reviewService.getAllReplies();
        model.addAttribute("replies", replies);
        return "admin/replies";
    } 
    @PostMapping("/reply/delete/{replyId}")
    public String deleteReply(@PathVariable int replyId){ 
        reviewService.deleteReplyById(replyId);
        return "redirect:/admin/replies";
    } 
    @GetMapping("/statistics") 
    public String viewStatistics(Model model){ 
        List<UsageStatistics> statistics = usageStatisticsService.getAllStatistics(); 
        model.addAttribute("statistics", statistics); 
        return "admin/statistics";
    } 
}
