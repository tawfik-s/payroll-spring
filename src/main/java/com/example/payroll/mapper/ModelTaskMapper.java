package com.example.payroll.mapper;

import com.example.payroll.dto.TaskWithUserIdDto;
import com.example.payroll.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Bean;

@Mapper
public interface ModelTaskMapper {

    @Mapping(target = "description",source = "taskDto.description")
    @Mapping(target="hours", source="taskDto.hours")
    Task taskDtoToEntity(TaskWithUserIdDto taskDto);

}
