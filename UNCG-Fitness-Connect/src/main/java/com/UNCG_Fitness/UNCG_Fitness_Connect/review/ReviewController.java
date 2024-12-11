package com.UNCG_Fitness.UNCG_Fitness_Connect.review;
import com.UNCG_Fitness.UNCG_Fitness_Connect.fitnessClass.Class;
import com.UNCG_Fitness.UNCG_Fitness_Connect.fitnessClass.ClassService;
import com.UNCG_Fitness.UNCG_Fitness_Connect.user.User;
import com.UNCG_Fitness.UNCG_Fitness_Connect.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @Autowired
    UserService userService;
    @Autowired
    ClassService classService;


    @Autowired
    private ReviewRepository reviewRepository;

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

    @PostMapping("/add")
    public ResponseEntity<String> addReview(
            @RequestParam int classId,
            @RequestParam int userId,
            @RequestParam int rating,
            @RequestParam String details
    ) {
        try {
            // Call the service to create a new review
            Review review = reviewService.createReview(classId, userId, rating, details);
            return ResponseEntity.ok("Review added successfully with ID: " + review.getReviewId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error creating review: " + e.getMessage());
        }
    }



    //This will update the status of a review
    @PutMapping("/update/status/{reviewId}")
    public String updateReviewStatus(@PathVariable int reviewId, @RequestBody boolean status, Model model){
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

    @PostMapping("/reply/{reviewId}")
    public String addReply(@PathVariable int reviewId, @RequestParam String reply) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new IllegalArgumentException("Review not found"));

        review.setReply(reply);
        reviewRepository.save(review);

        // Redirect to the same page (or a specific one)
        return "redirect:/classes/" + review.getClassId().getClassId();
    }


}