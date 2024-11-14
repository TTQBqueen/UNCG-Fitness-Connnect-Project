package com.UNCG_Fitness.UNCG_Fitness_Connect.review;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import jakarta.persistence.*; 
import java.util.List;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping("/all")
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }
    @GetMapping("/{reviewId}")
    public Review getReviewById(@PathVariable int reviewId){
        return reviewService.getReviewById(reviewId);
    }
    @PostMapping("/add")
    public Review addReview(@RequestBody Review review){
        return reviewService.createReview(review);
    }
    @PutMapping("/update/status/{reviewId}")
    public Review updateReviewStatus(@PathVariable int reviewId, @RequestBody String status){
        return reviewService.updateReviewStatus(reviewId, status);
    }
    @DeleteMapping("/delete/{reviewId}")
    public void deleteReviewById(@PathVariable int reviewId){
        reviewService.deleteReviewById(reviewId);
    }

}