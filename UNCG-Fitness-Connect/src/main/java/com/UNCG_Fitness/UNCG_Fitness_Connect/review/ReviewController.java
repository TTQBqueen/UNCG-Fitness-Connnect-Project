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
        return "/Admin/review";
        //return reviewService.getAllReviews();
    }

    // this will get one singular review by its name/ID
    @GetMapping("/{reviewId}")
    public String getReviewById(@PathVariable int reviewId, Model model){
        model.addAttribute("review", reviewService.getReviewById(reviewId));
        return "review-details";
        //return reviewService.getReviewById(reviewId);
    }

    //This will add a new review
    @PostMapping("/add/{classId}")
    public String addReview(@ModelAttribute Review review) {
        reviewService.createReview(review);
        return "redirect:/classes/all";

        //return reviewService.createReview(review);
    }

    //This will update the status of a review
    @PutMapping("/update/status/{reviewId}")
    public String updateReviewStatus(@PathVariable int reviewId, @RequestBody String status, Model model){
        model.addAttribute("review", reviewService.getReviewById(reviewId));
        return "review-update";
        //return re viewService.updateReviewStatus(reviewId, status);
    }

    // this will delete the review by its name/ID
    @DeleteMapping("/delete/{reviewId}")
    public String deleteReviewById(@PathVariable int reviewId){
        reviewService.deleteReviewById(reviewId);
        return "redirect:/reviews/all";
        //reviewService.deleteReviewById(reviewId);
    }
}