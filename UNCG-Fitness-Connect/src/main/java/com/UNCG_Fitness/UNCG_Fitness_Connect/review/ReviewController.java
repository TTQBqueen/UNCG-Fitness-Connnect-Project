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
  
    //This will get all the reviews
    @GetMapping("/all")
    public String getAllReviews(Model model) {
        model.addAttribute("reviewList", reviewService.getAllReviews());
        return "/Admin/review-list";
        //return reviewService.getAllReviews();
    } 

// this will get one singular review by its name/ID
    @GetMapping("/{reviewId}")
    public String getReviewById(@PathVariable int reviewId, Model model){
        model.addAttribute("review", reviewService.getReviewById(reviewId));
        return "/Admin/review-details";
        //return reviewService.getReviewById(reviewId);
    }
    @GetMapping("/add")
    public String showAddReview(Model model){
        model.addAttribute("review", new Review());
        return "Admin/review-add";
    }

    //This will add a new review
    @PostMapping("/add")
    public String addReview(@ModelAttribute Review review) {
        reviewService.createReview(review);
        return "redirect:/reviews/all";

        //return reviewService.createReview(review);
    }
    @GetMapping("update/status/{reviewId}")
    public String showUpdateReviewForm(@PathVariable int reviewId, Model model){
        Review review = reviewService.getReviewById(reviewId);
        model.addAttribute("review", review);
        return "/Admin/review-update";
    }

    //This will update the status of a review
    @PostMapping("/update/status/{reviewId}")
    public String updateReviewStatus(@PathVariable int reviewId, @RequestParam("status") String status){
        reviewService.updateReviewStatus(reviewId, status);
        //model.addAttribute("review", reviewService.getReviewById(reviewId));
        return "redirect:/reviews/all";
        //return reviewService.updateReviewStatus(reviewId, status);
    } 

    // this will delete the review by its name/ID
    @PostMapping("/delete/{reviewId}")
    public String deleteReviewById(@PathVariable int reviewId){ 
        reviewService.deleteReviewById(reviewId);
        return "redirect:reviews/all";
        //reviewService.deleteReviewById(reviewId);
    }
}