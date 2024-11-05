package com.UNCG_Fitness.UNCG_Fitness_Connect.subscribed;

import com.UNCG_Fitness.UNCG_Fitness_Connect.contants.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "subscribed")
public class Subscribed {

    // 0 = Unsubscribed (False), 1 = Subscribed/Finished (True)

    @Column(nullable = false)
    private Boolean class_subscribed;

    private Boolean class_unsubscribed;

    @Column(nullable = false)
    private Boolean class_registered;

    private Boolean class_completed;

    public Subscribed(Boolean class_subscribed, Boolean class_unsubscribed, Boolean class_registered, Boolean class_completed) {
        this.class_subscribed = class_subscribed;
        this.class_unsubscribed = class_unsubscribed;
        this.class_registered = class_registered;
        this.class_completed = class_completed;
    }

    public Boolean getClass_subscribed() {
        return class_subscribed;
    }

    public void setClass_subscribed(Boolean class_subscribed) {
        this.class_subscribed = class_subscribed;
    }

    public Boolean getClass_unsubscribed() {
        return class_unsubscribed;
    }

    public void setClass_unsubscribed(Boolean class_unsubscribed) {
        this.class_unsubscribed = class_unsubscribed;
    }

    public Boolean getClass_registered() {
        return class_registered;
    }

    public void setClass_registered(Boolean class_registered) {
        this.class_registered = class_registered;
    }

    public Boolean getClass_completed() {
        return class_completed;
    }

    public void setClass_completed(Boolean class_completed) {
        this.class_completed = class_completed;
    }

}
