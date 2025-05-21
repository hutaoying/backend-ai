package com.example.auth.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItem {
    private String name;
    private String code;
    private String path;
    private String icon;
    private List<MenuItem> children;

    public MenuItem(String name,String code, String path, String icon) {
        this.name = name;
        this.code = code;
        this.path = path;
        this.icon = icon;
    }
}