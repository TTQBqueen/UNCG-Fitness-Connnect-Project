package com.UNCG_Fitness.UNCG_Fitness_Connect.fitnessClass;

import com.UNCG_Fitness.UNCG_Fitness_Connect.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

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

    @Column(nullable = false)
    private Boolean flag;

    @Column(nullable = false)
    private Date updatedAt;

    @Column(nullable = false)
    private String Frequency;

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

//For the Instructor

    public Class(int classId, User creator, String title, String details, Date date, LocalTime startTime, LocalTime endTime,
                 String level, String instructorName, String status, String imagePath, Date createdAt, Date updatedAt,
                 int duration, boolean flag) {
        this.classId = classId;
        this.creator = creator;
        this.title = title;
        this.details = details;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.level = level;
        this.instructorName = instructorName;
        this.status = status;
        this.imagePath = imagePath;
        this.duration = duration;
        this.flag = false;
        this.createdAt= createdAt;
        this.updatedAt= updatedAt;

    }

    //    For admin

    public Class(User creator, String title, String details, Date date, LocalTime startTime, LocalTime endTime, String level, String instructorName, String status, String imagePath,Date createdAt ) {
        this.creator = creator;
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
}