package com.UNCG_Fitness.UNCG_Fitness_Connect.subscription;

import com.UNCG_Fitness.UNCG_Fitness_Connect.fitnessClass.Class;
import com.UNCG_Fitness.UNCG_Fitness_Connect.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "subscription")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "classId")
    private Class fitnessClass;

    public Subscription(long id, User user, Class fitnessClass) {
        this.id = id;
        this.user = user;
        this.fitnessClass = fitnessClass;
    }

    public Subscription(User user, Class fitnessClass) {
        this.user = user;
        this.fitnessClass = fitnessClass;
    }

    public Subscription() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Class getFitnessClass() {
        return fitnessClass;
    }

    public void setFitnessClass(Class fitnessClass) {
        this.fitnessClass = fitnessClass;
    }
}
