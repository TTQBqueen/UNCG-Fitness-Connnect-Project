package com.UNCG_Fitness.UNCG_Fitness_Connect.review;
import com.UNCG_Fitness.UNCG_Fitness_Connect.fitnessClass.Class;
import com.UNCG_Fitness.UNCG_Fitness_Connect.fitnessClass.ClassService;
import com.UNCG_Fitness.UNCG_Fitness_Connect.user.User;
import com.UNCG_Fitness.UNCG_Fitness_Connect.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @PostMapping("/STUDENT/add")
    public String createReview(@ModelAttribute Review review, @RequestParam int classId) {
        // Fetch the currently logged-in user's username
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        // Set the user (creator) of the review
        User user = userService.getUserByUserName(name);
        review.setUserId(user);
        // Fetch the associated class and set it in the review
        Class fitnessClass = classService.getClassById(classId);
        review.setClassId(fitnessClass);

        // Save the review
        reviewService.createReview(review);

        // Redirect to the class details or all classes page
        return "redirect:/classes/" + classId;
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

    //This will update the status of a review
    @PostMapping("/update/status/{reviewId}")
    public String updateReviewStatus(@PathVariable int reviewId, @RequestParam boolean status) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new IllegalArgumentException("Review not found"));

        // Update the status field
        review.setStatus(status);
        reviewRepository.save(review);

        // Redirect back to the class details page
        return "redirect:/classes/" + review.getClassId().getClassId();
    }

    @GetMapping("/reviews/unflagged")
    public String getUnflaggedReviews(Model model) {
        List<Review> unflaggedReviews = reviewService.getUnflaggedReviews();
        model.addAttribute("reviews", unflaggedReviews);
        return "reviews/list";
    }

}