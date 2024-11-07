package com.UNCG_Fitness.UNCG_Fitness_Connect.review;

import java.util.Date;
import jakarta.persistence.*;


@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reviewId;

    @Column(nullable = false)
    private int classId;

    @Column(nullable = false)
    private int rating;

    @Column(nullable = false)
    private int userId;

    @Column(nullable = false)
    private String details;

    private Date createdAt;

    private Date updatedAt;

    private String status;

    public Review(int reviewId, int classId, int rating, int userId, String details, Date createdAt, Date updatedAt, String status) {
        this.reviewId = reviewId;
        this.classId = classId;
        this.rating = rating;
        this.userId = userId;
        this.details = details;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }
    public Review(String reviewId, String classId, String userId, String details, Date created, Date updated, String status) {
    }
    public Review(){
    }

    public int getReviewId() {
        return reviewId;
    }
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }
    public int getClassId() {
        return classId;
    }
    public void setClassId(int classId) {
        this.classId = classId;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}