package com.UNCG_Fitness.UNCG_Fitness_Connect.fitnessClass;

import com.UNCG_Fitness.UNCG_Fitness_Connect.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.sql.Date;

import java.time.LocalTime;

@Entity
@Table(name = "class")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int classId;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String details;

    @Column(nullable = false)
    private Date date;
    
    @Column(nullable = false)
    private LocalTime startTime;

    @Column(nullable = false)
    private LocalTime endTime;

    @Column(nullable = false)
    private String level;

    @Column(nullable = false)
    private String instructorName;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String imagePath;


    public Class(User user) {
        this.user = new User();
    }

    public Class(int classId, User user, @NonNull String title, String details, @NonNull Date date, @NonNull LocalTime startTime, @NonNull LocalTime endTime, String level, String instructorName, @NonNull String status, String imagePath) {
        this.classId = classId;
        this.user = user;
        this.title = title;
        this.details = details;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.level = level;
        this.instructorName = instructorName;
        this.status = status;
        this.imagePath = imagePath;
    }
//
//    public Class(User user, @NonNull String title, @NonNull Date date, @NonNull LocalTime startTime, @NonNull LocalTime endTime, String instructorName, String details) {
//        this.user = user;
//        this.title = title;
//        this.date = date;
//        this.details = details;
//        this.startTime = startTime;
//        this.endTime = endTime;
//        this.instructorName = instructorName;
//        this.status = Status.Canceled;
//    }

//    public Class(Class class) {
//        this.classId = class.getClassId();
//        this.user = class.getUser();
//        this.title = class.getTitle();
//        this.details = class.getDetails();
//        this.date = date;
//        this.startTime = class.getStartTime();
//        this.endTime = class.getEndTime();
//        this.level = class.getLevel();
//        this.instructorName = class.getInstructorName();
//        this.status = class.getStatus();
//    }
public Class(){}
    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
    @NonNull
    public Date getDate() {
        return date;
    }

    public void setDate(@NonNull Date date) {
        this.date = date;
    }

    @NonNull
    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(@NonNull LocalTime startTime) {
        this.startTime = startTime;
    }

    @NonNull
    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(@NonNull LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @NonNull
    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(@NonNull String instructorName) {
        this.instructorName = instructorName;
    }

    @NonNull
    public String getStatus() {
        return status;
    }

    public void setStatus(@NonNull String status) {
        this.status = status;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Class{" +
                "classId=" + classId +
                ", user=" + user +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", status=" + status +
                '}';
    }
}
