package com.example.payroll.entity;

import lombok.*;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Employee {

    private @Id @GeneratedValue Long id;

    @NotNull
    private String name;
    private String role;

    private String phone;

    @OneToMany
    @JoinTable(name="Employee_task",joinColumns = {@JoinColumn(name="Employee_id")},
            inverseJoinColumns = {@JoinColumn(name="task_id")})
    private List<Task> tasks;



}