package com.raven.backendai.controller;

import org.springframework.web.bind.annotation.*;

import com.raven.backendai.model.ApiResponse;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/stats")
public class StatsController {

    @GetMapping("/dashboard")
    public ApiResponse<?> getDashboardStats() {
        // 创建统计数据Map
        Map<String, Integer> statsData = new HashMap<>();
        statsData.put("todoCount", 10);      // 待办事项数量
        statsData.put("doneCount", 11);      // 已办事项数量
        statsData.put("pendingApprovalCount", 20);   // 待审批事项数量
        statsData.put("approvedCount", 30);  // 已审批事项数量

        return new ApiResponse<>(200, "success", statsData);
    }
}