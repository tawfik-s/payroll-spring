package com.example.payroll.controller;

import com.example.payroll.dto.TaskWithUserIdDto;
import com.example.payroll.entity.Task;
import com.example.payroll.repository.TaskRepository;
import com.example.payroll.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/Task")
    public Task assignTaskToUser(@RequestBody TaskWithUserIdDto taskDto){
        return taskService.addTask(taskDto);
    }

}
