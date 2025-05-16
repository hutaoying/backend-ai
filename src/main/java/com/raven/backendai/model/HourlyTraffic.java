package com.raven.backendai.model;

public class HourlyTraffic {
    private String time;
    private int occupancy;

    public HourlyTraffic(String time, int occupancy) {
        this.time = time;
        this.occupancy = occupancy;
    }

    // Getters and Setters
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }
}
