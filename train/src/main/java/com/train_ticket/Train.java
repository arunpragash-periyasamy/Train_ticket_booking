package com.train_ticket;

public class Train {
    private int id;
    private String trainNumber;
    private String destination;
    private String departure;
    private String departureTime;

    // Constructor
    public Train() {
    }

    public Train(String trainNumber, String destination, String departureTime, String departure) {
        this.trainNumber = trainNumber;
        this.destination = destination;
        this.departureTime = departureTime;
        this.departure = departure;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }
}