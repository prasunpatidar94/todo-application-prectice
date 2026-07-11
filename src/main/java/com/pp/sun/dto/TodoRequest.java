package com.pp.sun.dto;


import com.pp.sun.helper.TodoPriority;
import com.pp.sun.helper.TodoStatus;
import com.pp.sun.helper.TodoType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TodoRequest {

    @NotBlank
    private String todoName;

    private String todoDescription;

    @NotNull
    private TodoStatus status;

    @NotNull
    private TodoPriority priority;

    @NotNull
    private TodoType type;

    @NotNull
    private LocalDate dueDate;

    @NotNull
    private Long categoryId;
}