package com.example.auth.model;

public class ToiletStatus {
    private String id;
    private String name;
    private String location;
    private int currentOccupancy;
    private int totalStalls;
    private double occupancyRate;
    private String status;

    public ToiletStatus(String id, String name, String location, int currentOccupancy, int totalStalls, double occupancyRate, String status) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.currentOccupancy = currentOccupancy;
        this.totalStalls = totalStalls;
        this.occupancyRate = occupancyRate;
        this.status = status;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCurrentOccupancy() {
        return currentOccupancy;
    }

    public void setCurrentOccupancy(int currentOccupancy) {
        this.currentOccupancy = currentOccupancy;
    }

    public int getTotalStalls() {
        return totalStalls;
    }

    public void setTotalStalls(int totalStalls) {
        this.totalStalls = totalStalls;
    }

    public double getOccupancyRate() {
        return occupancyRate;
    }

    public void setOccupancyRate(double occupancyRate) {
        this.occupancyRate = occupancyRate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
