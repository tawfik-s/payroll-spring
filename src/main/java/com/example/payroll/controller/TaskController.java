package com.example.payroll.controller;

import com.example.payroll.dto.TaskWithUserIdDto;
import com.example.payroll.entity.Task;
import com.example.payroll.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/Task")
    public Task assignTaskToUser(@RequestBody TaskWithUserIdDto taskDto){
        return taskService.addTask(taskDto);
    }

    @GetMapping("/Task/employee/{id}")
    public List<Task> findEmployeeTasks(@PathVariable Long id){
        return taskService.getEmployeeTasks(id);
    }

    @GetMapping("/Task/{id}")
    public Task getTask(@PathVariable Long id){
        return taskService.getTaskById(id);
    }

    @PutMapping("/Task/{id}")
    public Task updateTask(@RequestParam Long id,@RequestBody Task task){
        return taskService.updateTask(task,id);
    }





}
