package com.example.payroll.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Task {
    private @Id
    @GeneratedValue Long id;

    @NotNull
    private String description;

    @Min(1)
    @Max(100)
    private String hours;

    private String status;


}
