package com.UNCG_Fitness.UNCG_Fitness_Connect.review; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;  

import java.util.Date; 
import java.util.List;  
import java.util.Optional;

@Service
public class ReviewService { 

    @Autowired
    ReviewRepository reviewRepository; 

    public List<Review> getAllReviews(){ 
        return reviewRepository.findAll();
    } 
    public Review getReviewById(int reviewId){  
        return reviewRepository.findById(reviewId).orElse(null); 
    }  
    public Review createReview(Review review){
        review.setCreatedAt(new Date());
        return reviewRepository.save(review);
    } 
    public Review updateReviewStatus(int reviewId, String status){
        Optional<Review> reviewOptional = reviewRepository.findById(reviewId); 
        if(reviewOptional.isPresent()){
            Review review = reviewOptional.get();
            review.setStatus(status); 
            review.setUpdatedAt(new Date());
            return reviewRepository.save(review);
        } 
        return null;
    } 
    public void deleteReviewById(int reviewId){ 
        reviewRepository.deleteById(reviewId);  
    }
}
