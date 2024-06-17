package com.train_ticket;

public class Ticket {
    private int id;
    private int userId;
    private int trainId;
    private String dateOfJourney;
    private int seatNumber;

    // Constructor
    public Ticket() {
    }

    public Ticket(int userId, int trainId, String dateOfJourney, int seatNumber) {
        this.userId = userId;
        this.trainId = trainId;
        this.dateOfJourney = dateOfJourney;
        this.seatNumber = seatNumber;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getDateOfJourney() {
        return dateOfJourney;
    }

    public void setDateOfJourney(String dateOfJourney) {
        this.dateOfJourney = dateOfJourney;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}