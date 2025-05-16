package com.raven.backendai.model;

import lombok.Data;
import java.util.List;

@Data
public class RiskAssetsRequest {
    private String name;
    private List<String> riskType;
    private String organizationId;
    private Integer page;
    private Integer size;
}