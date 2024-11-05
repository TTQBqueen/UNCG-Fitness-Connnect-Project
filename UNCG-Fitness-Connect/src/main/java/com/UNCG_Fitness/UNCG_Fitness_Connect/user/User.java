package com.UNCG_Fitness.UNCG_Fitness_Connect.user;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.Date;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private String profilePic_url;

    private String bio;

    @Column(nullable = false)
    private LocalTime joinDate;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private Boolean flagged;

    public User(String userName, String email, String firstName, String lastName, String profilePic_url, String bio, LocalTime joinDate, String role) {
        this.userName = userName;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePic_url = profilePic_url;
        this.bio = bio;
        this.joinDate = joinDate;
        this.role = role;
    }

    public User(long userId, String userName, String email, String firstName, String lastName, String profilePic_url, String bio, LocalTime joinDate, String role) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePic_url = profilePic_url;
        this.bio = bio;
        this.joinDate = joinDate;
        this.role = role;
    }

    public User(long userId) {
        this.userId = userId;
    }

    public User() {
    }

    public long getId() {
        return userId;
    }

    public void setId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String firstName) {
        this.lastName = lastName;
    }

    public String getProfilePic_url() {
        return profilePic_url;
    }

    public void setProfilePic_url(String profilePic_url) {
        this.profilePic_url = profilePic_url;
    }

    public String getBio() {
        return bio;
    }

    public void bio(String bio) {
        this.bio = bio;
    }

    public LocalTime getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = LocalTime.parse(joinDate);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getFlagged() {
        return flagged;
    }

    public void setFlagged(Boolean flagged) {
        this.flagged = flagged;
    }
}
