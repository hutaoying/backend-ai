package com.raven.backendai.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.raven.backendai.model.*;
import com.alibaba.fastjson2.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/risk")
public class RiskController {
    
    @Autowired
    private ResourceLoader resourceLoader;

    @GetMapping("/assets")
    public PageResponse<RiskAsset> getRiskAssets(RiskAssetsRequest request) throws IOException {
        // 使用 ResourceLoader 读取 JSON 文件
        var resource = resourceLoader.getResource("classpath:response/mockData.json");
        String jsonContent = StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
        
        // 使用 FastJSON 解析 JSON 数据
        JSONObject rootObj = JSON.parseObject(jsonContent);
        JSONArray assetsArray = rootObj.getJSONArray("assets");
        
        // 转换为 RiskAsset 对象列表
        List<RiskAsset> assets = assetsArray.stream()
            .map(obj -> JSON.parseObject(JSON.toJSONString(obj), RiskAsset.class))
            .filter(asset -> asset.getId() != null && asset.getName() != null && asset.getIdentifier() != null)
            .collect(Collectors.toList());

        // 创建分页响应
        PageResponse<RiskAsset> response = new PageResponse<>();
        response.setCode(200);
        response.setTotal(assets.size());
        response.setPage(request.getPage());
        response.setSize(request.getSize());
        
        // 计算分页数据
        int start = (request.getPage() - 1) * request.getSize();
        int end = Math.min(start + request.getSize(), assets.size());
        List<RiskAsset> pageData = assets.subList(Math.max(0, start), Math.max(0, end));
        
        response.setData(pageData);
        return response;
    }
    
    @GetMapping("/org-rankings")
    public ApiResponse<List<OrgRanking>> getOrgRankings() {
        List<OrgRanking> rankings = Arrays.asList(
            new OrgRanking("数据中心1", 92),
            new OrgRanking("应用中心1", 88),
            new OrgRanking("应用中心2", 80)
        );
        
        return new ApiResponse<>(200, "success", rankings);
    }
}