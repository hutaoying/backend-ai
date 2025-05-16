package com.raven.backendai.controller;

import org.springframework.web.bind.annotation.*;

import com.raven.backendai.model.ApiResponse;
import com.raven.backendai.model.MenuItem;

import java.util.List;
import java.util.Arrays;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @GetMapping("/list")
    public ApiResponse<List<MenuItem>> getMenuList() {
        // 创建子菜单项
        MenuItem todoItem = new MenuItem("待办事项", "todo", "/todo", "el-icon-document");
        MenuItem doneItem = new MenuItem("已办事项", "done", "/done", "el-icon-check");
        
        // 创建协同工作菜单及其子菜单
        MenuItem collaborativeWork = new MenuItem();
        collaborativeWork.setName("协同工作");
        collaborativeWork.setCode("xietong");
        collaborativeWork.setPath("");
        collaborativeWork.setIcon("el-icon-monitor");
        collaborativeWork.setChildren(Arrays.asList(todoItem, doneItem));

        // 创建公共服务子菜单项
        MenuItem leaveItem = new MenuItem("请假申请", "qingjia", "/qingjia", "el-icon-time");
        MenuItem expenseItem = new MenuItem("报销申请", "baoxiao", "/bx", "el-icon-money");
        
        // 创建公共服务菜单及其子菜单
        MenuItem publicService = new MenuItem();
        publicService.setName("公共服务");
        publicService.setCode("gg");
        publicService.setPath("");
        publicService.setIcon("el-icon-service");
        publicService.setChildren(Arrays.asList(leaveItem, expenseItem));

         // 创建ai辅助编码学习菜单及其子菜单

         MenuItem demo1 = new MenuItem("列表展示", "listShow", "/listShow", "el-icon-time");
         MenuItem aiLearMenuItem = new MenuItem();
         aiLearMenuItem.setName("aiLearn");
         aiLearMenuItem.setCode("aiLearn");
         aiLearMenuItem.setPath("");
         aiLearMenuItem.setIcon("el-icon-service");
         aiLearMenuItem.setChildren(Arrays.asList(demo1));

        return new ApiResponse<>(200, "success", Arrays.asList(collaborativeWork, publicService,aiLearMenuItem));
    }
}