package com.example.payroll.service;

import com.example.payroll.dto.TaskWithUserIdDto;
import com.example.payroll.entity.Task;

import java.util.List;

public interface TaskService {

    public Task addTask(TaskWithUserIdDto taskDto);
    public Task getTaskById(long id);
    public List<Task> getTasks();
    public void deleteTask(long id);
    public Task updateTask(Task task,long id);
}
