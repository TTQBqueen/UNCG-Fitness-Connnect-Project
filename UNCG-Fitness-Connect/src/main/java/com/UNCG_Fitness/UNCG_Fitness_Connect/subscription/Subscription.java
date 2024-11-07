package com.UNCG_Fitness.UNCG_Fitness_Connect.subscription;

import com.UNCG_Fitness.UNCG_Fitness_Connect.fitnessClass.Class;
import com.UNCG_Fitness.UNCG_Fitness_Connect.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "subscription")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int subs_id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "classId")
    private Class fitnessClass;

    public Subscription(int subs_id, User user, Class fitnessClass) {
        this.subs_id = subs_id;
        this.user = user;
        this.fitnessClass = fitnessClass;
    }

    public Subscription(User user, Class fitnessClass) {
        this.user = user;
        this.fitnessClass = fitnessClass;
    }

    public Subscription() {
    }

    public int getId() {
        return subs_id;
    }

    public void setId(int subs_id) {
        this.subs_id = subs_id;
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
