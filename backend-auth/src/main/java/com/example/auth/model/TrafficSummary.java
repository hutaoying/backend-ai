package com.example.auth.model;

public class TrafficSummary {
    private int currentTotalOccupancy;
    private int currentAvailableStalls;
    private int todayTotalUsageCount;

    public TrafficSummary(int currentTotalOccupancy, int currentAvailableStalls, int todayTotalUsageCount) {
        this.currentTotalOccupancy = currentTotalOccupancy;
        this.currentAvailableStalls = currentAvailableStalls;
        this.todayTotalUsageCount = todayTotalUsageCount;
    }

    // Getters and Setters
    public int getCurrentTotalOccupancy() {
        return currentTotalOccupancy;
    }

    public void setCurrentTotalOccupancy(int currentTotalOccupancy) {
        this.currentTotalOccupancy = currentTotalOccupancy;
    }

    public int getCurrentAvailableStalls() {
        return currentAvailableStalls;
    }

    public void setCurrentAvailableStalls(int currentAvailableStalls) {
        this.currentAvailableStalls = currentAvailableStalls;
    }

    public int getTodayTotalUsageCount() {
        return todayTotalUsageCount;
    }

    public void setTodayTotalUsageCount(int todayTotalUsageCount) {
        this.todayTotalUsageCount = todayTotalUsageCount;
    }
}
