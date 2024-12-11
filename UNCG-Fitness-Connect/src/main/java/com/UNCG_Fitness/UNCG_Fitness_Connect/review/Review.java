package com.UNCG_Fitness.UNCG_Fitness_Connect.review;

import com.UNCG_Fitness.UNCG_Fitness_Connect.user.User;
import com.UNCG_Fitness.UNCG_Fitness_Connect.fitnessClass.Class;


import jakarta.persistence.Entity;
import jakarta.persistence.*;
import java.util.Date;



@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reviewId;

    @ManyToOne
    @JoinColumn(name = "classId", nullable = false)
    private Class classId;


    @Column(nullable = false)
    private int rating;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User userId;

    @Column(nullable = false)
    private String details;

    @Column(nullable = false)
    private boolean status;

//    @Column(nullable = true)
//    private String reply;


    public Review(int reviewId, Class classId, int rating, User userId, String details, boolean status) {
        this.reviewId = reviewId;
        this.classId = classId;
        this.rating = rating;
        this.userId = userId;
        this.details = details;
        this.status = status;
//        this.reply = reply;
    }
    public Review( boolean status) {
        this.status = status;
    }
    public Review(String reviewId, Class classId, User userId, String details, Date created, Date updated, boolean status) {
    }
    public Review(){
    }

    public int getReviewId() {
        return reviewId;
    }
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }
    public Class getClassId() {
        return classId;
    }
    public void getClassId(Class classId) {this.classId = classId;}
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public User getUserId() {
        return userId;
    }
    public void setUserId(User userId) {
        this.userId = userId;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }

    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

//    public String getReply() {
//        return reply;
//    }
//
//    public void setReply(String reply) {
//        this.reply = reply;
//    }
//
//    public void setClassId(Class classId) {
//        this.classId = classId;
//    }
//
//    public boolean isStatus() {
//        return status;
//    }
}