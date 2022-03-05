package com.bapoto.vtc.model;

import com.google.firebase.firestore.ServerTimestamp;

import java.time.LocalTime;
import java.util.Date;

public class Message {

    private Date dateCreated;
    private LocalTime hourCreated;
    private User userSender;
    private String pickUp;
    private String destination;
    private String message;

    public Message() {
    }

    public Message(String message, User userSender) {
        this.message = message;
        this.userSender = userSender;
    }

    public Message(Date dateCreated, String message, LocalTime hourCreated, User userSender, String pickUp, String destination) {
        this.dateCreated = dateCreated;
        this.hourCreated = hourCreated;
        this.userSender = userSender;
        this.pickUp = pickUp;
        this.destination = destination;
        this.message = message;

    }

    public Message(String textMessage, String urlImage, User user) {
    }


    @ServerTimestamp
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalTime getHourCreated() {
        return hourCreated;
    }

    public void setHourCreated(LocalTime hourCreated) {
        this.hourCreated = hourCreated;
    }

    public User getUserSender() {
        return userSender;
    }

    public void setUserSender(User userSender) {
        this.userSender = userSender;
    }

    public String getPickUp() {
        return pickUp;
    }

    public void setPickUp(String pickUp) {
        this.pickUp = pickUp;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
