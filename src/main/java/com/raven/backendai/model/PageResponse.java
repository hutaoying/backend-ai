package com.raven.backendai.model;

import lombok.Data;
import java.util.List;

@Data
public class PageResponse<T> {
    private Integer code;
    private Integer total;
    private Integer page;
    private Integer size;
    private List<T> data;
}