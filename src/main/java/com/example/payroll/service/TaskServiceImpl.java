package com.example.payroll.service;

import com.example.payroll.dto.TaskWithUserIdDto;
import com.example.payroll.entity.Employee;
import com.example.payroll.entity.Task;
import com.example.payroll.mapper.ModelTaskMapper;
import com.example.payroll.repository.EmployeeRepository;
import com.example.payroll.repository.TaskRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private EmployeeService employeeService;
    private TaskRepository taskRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    private ModelTaskMapper taskMapper= Mappers.getMapper(ModelTaskMapper.class);

    @Autowired
    public void setTaskRepository(TaskRepository taskRepository){
        this.taskRepository=taskRepository;
    }


    @Override
    public Task addTask(TaskWithUserIdDto taskDto) {
        Employee employee=employeeService.getEmployeeById(taskDto.getEmployee_id());
        Task task=taskMapper.taskDtoToEntity(taskDto);
        taskRepository.save(task);
        employee.getTasks().add(task);
        employeeRepository.save(employee);
        return task;
    }

    @Override
    public Task getTaskById(long id) {
        return null;
    }

    @Override
    public List<Task> getTasks() {
        return null;
    }

    @Override
    public void deleteTask(long id) {

    }

    @Override
    public Task updateTask(Task task, long id) {
        return null;
    }
}
