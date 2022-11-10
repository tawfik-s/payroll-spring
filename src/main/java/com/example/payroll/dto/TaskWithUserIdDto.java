package com.example.payroll.dto;

import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class TaskWithUserIdDto {

    @NotNull
    private long employee_id;

    private String description;

    private String hours;

    private String status;

}
