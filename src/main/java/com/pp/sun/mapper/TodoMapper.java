package com.pp.sun.mapper;


import com.pp.sun.dto.TodoResponse;
import com.pp.sun.entity.Todo;

public class TodoMapper {

    public static TodoResponse toResponse(Todo todo) {

        return TodoResponse.builder()
                .id(todo.getId())
                .todoName(todo.getTodoName())
                .todoDescription(todo.getTodoDescription())
                .status(todo.getStatus())
                .priority(todo.getPriority())
                .type(todo.getType())
                .dueDate(todo.getDueDate())
                .creationDate(todo.getCreationDate())
                .lastUpdatedDate(todo.getLastUpdatedDate())
                .category(todo.getCategory().getCategoryName())
                .build();
    }

}