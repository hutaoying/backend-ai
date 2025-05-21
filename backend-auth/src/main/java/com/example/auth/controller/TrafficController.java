package com.example.auth.controller;


import com.example.auth.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api")
public class TrafficController {

    private final Random random = new Random();

    @GetMapping("/traffic/summary")
    public TrafficSummary getTrafficSummary() {
        // Simulate dynamic data
        int currentOccupancy = 50 + random.nextInt(151); // 50 to 200
        int totalStalls = 500;
        int availableStalls = totalStalls - currentOccupancy;
        if (availableStalls < 0) availableStalls = 0;
        int todayUsage = 1000 + random.nextInt(1001); // 1000 to 2000
        return new TrafficSummary(currentOccupancy, availableStalls, todayUsage);
    }

    @GetMapping("/toilets/status")
    public List<ToiletStatus> getToiletsStatus() {
        List<ToiletStatus> statuses = new ArrayList<>();
        String[] names = {"人民广场北侧公共厕所", "中山公园东门公共厕所", "世纪大道地铁站公共厕所", "外滩观景平台公共厕所", "科技园区A栋一层公共厕所", "中央车站南广场公共厕所", "城市图书馆公共厕所", "体育中心西门公共厕所"};
        String[] locations = {"人民广场北侧", "中山公园东门", "世纪大道地铁站", "外滩观景平台", "科技园区A栋一层", "中央车站南广场", "城市图书馆", "体育中心西门"};
        String[] statusOptions = {"空闲", "繁忙", "拥挤", "维护中"};

        for (int i = 0; i < 8; i++) {
            String id = "toilet_00" + (i + 1);
            int totalStalls = 20 + random.nextInt(31); // 20 to 50 stalls
            int currentOccupancy = random.nextInt(totalStalls + 1);
            double occupancyRate = (double) currentOccupancy / totalStalls;
            String status = statusOptions[random.nextInt(statusOptions.length)];
            if (status.equals("维护中")) {
                currentOccupancy = 0;
                occupancyRate = 0;
            }
            statuses.add(new ToiletStatus(id, names[i], locations[i], currentOccupancy, totalStalls, occupancyRate, status));
        }
        return statuses;
    }

    @GetMapping("/traffic/history")
    public TrafficHistory getTrafficHistory(@RequestParam(required = false) String toilet_id) {
        List<HourlyTraffic> hourlyTrafficLast24h = new ArrayList<>();
        List<HourlyAverageOccupancyRate> todayHourlyAverageOccupancyRate = new ArrayList<>();
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        for (int i = 0; i < 24; i++) {
            LocalTime hour = currentTime.minusHours(23 - i);
            hourlyTrafficLast24h.add(new HourlyTraffic(hour.format(timeFormatter), 5 + random.nextInt(46))); // 5 to 50
            
            String hourPeriod = String.format("%02d-%02d", i, (i + 1) % 24);
            todayHourlyAverageOccupancyRate.add(new HourlyAverageOccupancyRate(hourPeriod, random.nextDouble()));
        }
        
        // If toilet_id is provided, we could potentially filter or provide specific data
        // For this mock, we return the same aggregated data regardless of toilet_id
        return new TrafficHistory(hourlyTrafficLast24h, todayHourlyAverageOccupancyRate);
    }
}

