package com.example.auth.model;

import java.util.List;

public class TrafficHistory {
    private List<HourlyTraffic> hourlyTrafficLast24h;
    private List<HourlyAverageOccupancyRate> todayHourlyAverageOccupancyRate;

    public TrafficHistory(List<HourlyTraffic> hourlyTrafficLast24h, List<HourlyAverageOccupancyRate> todayHourlyAverageOccupancyRate) {
        this.hourlyTrafficLast24h = hourlyTrafficLast24h;
        this.todayHourlyAverageOccupancyRate = todayHourlyAverageOccupancyRate;
    }

    // Getters and Setters
    public List<HourlyTraffic> getHourlyTrafficLast24h() {
        return hourlyTrafficLast24h;
    }

    public void setHourlyTrafficLast24h(List<HourlyTraffic> hourlyTrafficLast24h) {
        this.hourlyTrafficLast24h = hourlyTrafficLast24h;
    }

    public List<HourlyAverageOccupancyRate> getTodayHourlyAverageOccupancyRate() {
        return todayHourlyAverageOccupancyRate;
    }

    public void setTodayHourlyAverageOccupancyRate(List<HourlyAverageOccupancyRate> todayHourlyAverageOccupancyRate) {
        this.todayHourlyAverageOccupancyRate = todayHourlyAverageOccupancyRate;
    }
}
