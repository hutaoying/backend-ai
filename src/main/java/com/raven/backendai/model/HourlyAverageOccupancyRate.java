package com.raven.backendai.model;

public class HourlyAverageOccupancyRate {
    private String hourPeriod;
    private double averageRate;

    public HourlyAverageOccupancyRate(String hourPeriod, double averageRate) {
        this.hourPeriod = hourPeriod;
        this.averageRate = averageRate;
    }

    // Getters and Setters
    public String getHourPeriod() {
        return hourPeriod;
    }

    public void setHourPeriod(String hourPeriod) {
        this.hourPeriod = hourPeriod;
    }

    public double getAverageRate() {
        return averageRate;
    }

    public void setAverageRate(double averageRate) {
        this.averageRate = averageRate;
    }
}
