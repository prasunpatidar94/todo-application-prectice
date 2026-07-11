package com.pp.sun.dto;

import com.pp.sun.helper.TodoPriority;
import com.pp.sun.helper.TodoStatus;
import com.pp.sun.helper.TodoType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class TodoResponse {

    private Long id;

    private String todoName;

    private String todoDescription;

    private TodoStatus status;

    private TodoPriority priority;

    private TodoType type;

    private LocalDate dueDate;

    private LocalDateTime creationDate;

    private LocalDateTime lastUpdatedDate;

    private String category;
}