package com.example.auth.model;

import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RiskAsset {
    private String id;
    private String name;
    private String identifier;
    private String organizationId;
    private String organizationName;
    private String riskType;
    private Integer score;
    private String ratingTags;
    private String ratingTime;
}