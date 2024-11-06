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
    @JoinColumn(name = "creatorId")
    private User creatorId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String details;

    @Column(nullable = false)
    private Date date;
    
    @Column(nullable = false)
    private int duration;
    
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

    @Column(nullable = false)
    private Date createdAt;

    @Column(nullable = false)
    private Boolean flag;
    
    @Column(nullable = false)
    private Date updatedAt;

    @Column(nullable = false)
    private int signups;
    
    
    public Class(String title) {
        this.title = title;
    }


public Class(){

}
    public int getClassId() {

        return classId;
    }


    public void setClassId(int classId) {
        this.classId = classId;
    }

    public User getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(User creatorId) {
        this.creatorId = creatorId;
    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public int getSignups() {
        return signups;
    }

    public void setSignups(int signups) {
        this.signups = signups;
    }

    //For the Instructor
    public Class(User creatorId, String title, String details, Date date, LocalTime startTime, LocalTime endTime, String level, String instructorName, String status, String imagePath, Date createdAt, Date updatedAt, int duration, int signups) {
        this.creatorId = creatorId;
        this.title = title;
        this.details = details;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.level = level;
        this.instructorName = instructorName;
        this.status = status;
        this.imagePath = imagePath;
        this.createdAt=createdAt;
        this.updatedAt=updatedAt;
        this.duration = duration;
        this.signups = signups;
    }

//    For admin
public Class(int classId,User creatorId, String title, String details, Date date, String instructorName, String status, int signups) {
    this.classId = classId;
    this.creatorId = creatorId;
    this.title = title;
    this.details = details;
    this.date = date;
    this.instructorName = instructorName;
    this.status = status;
    this.signups = signups;
}

//short information
public Class(String title, String details, Date date, String level, String instructorName, String status, Date createdAt, Boolean flag) {
    this.title = title;
    this.details = details;
    this.date = date;
    this.level = level;
    this.instructorName = instructorName;
    this.status = status;
    this.createdAt=createdAt;
    this.flag = flag;
}


    @Override
    public String toString() {
        return "Class{" +
                "classId=" + classId +
                ", user=" + creatorId +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", status=" + status +
                '}';
    }
}
