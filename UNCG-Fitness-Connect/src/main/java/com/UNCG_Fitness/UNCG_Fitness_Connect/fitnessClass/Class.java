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
    @JoinColumn(name = "creatorid")
    private User creator;

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

    private Boolean flag;



    @Column(nullable = false)
    private Date updatedAt;

    public Class(String title) {
        this.title = title;
    }


    public Class(){

    }
    public int getId() {

        return classId;
    }

    public void setId(int classId) {
        this.classId = classId;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
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



    //For the Instructor
    public Class(User creatorid, String title, String details, Date date, LocalTime startTime, LocalTime endTime, String level, String instructorName, String status, String imagePath, Date createdAt, Date updatedAt) {
        this.creator = creatorid;
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
    }

    //    For admin
    public Class(String title, String details, Date date, LocalTime startTime, LocalTime endTime, String level, String instructorName, String status, String imagePath) {
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

    //short information
    public Class(String title, String details, Date date, String level, String instructorName, String status, Date createdAt) {
        this.title = title;
        this.details = details;
        this.date = date;
        this.level = level;
        this.instructorName = instructorName;
        this.status = status;
        this.createdAt=createdAt;
    }


    @Override
    public String toString() {
        return "Class{" +
                "classId=" + classId +
                ", user=" + creator +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", status=" + status +
                '}';
    }
}