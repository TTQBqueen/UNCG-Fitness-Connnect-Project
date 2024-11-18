package com.UNCG_Fitness.UNCG_Fitness_Connect.review;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    ReviewService reviewService;
  
    @GetMapping("/all")
    public String getAllReviews(Model model) {
        model.addAttribute("reviewList", reviewService.getAllReviews());
        return "review-list";
        //return reviewService.getAllReviews();
    } 


    @GetMapping("/{reviewId}")
    public String getReviewById(@PathVariable int reviewId, Model model){
        model.addAttribute("review", reviewService.getReviewById(reviewId));
        return "review-details";
        //return reviewService.getReviewById(reviewId);
    } 

    @PostMapping("/add")
    public String addReview(@ModelAttribute Review review) {
        reviewService.createReview(review);
        return "redirect:/reviews/all";

        //return reviewService.createReview(review);
    }  

    @PutMapping("/update/status/{reviewId}")
    public String updateReviewStatus(@PathVariable int reviewId, @RequestBody String status, Model model){ 
        model.addAttribute("review", reviewService.getReviewById(reviewId)); 
        return "review-update"; 
        //return reviewService.updateReviewStatus(reviewId, status);
    }
    @DeleteMapping("/delete/{reviewId}")
    public String deleteReviewById(@PathVariable int reviewId){ 
        reviewService.deleteReviewById(reviewId);
        return "redirect:/reviews/all";
        //reviewService.deleteReviewById(reviewId);
    }

}